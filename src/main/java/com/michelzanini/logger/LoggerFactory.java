/*******************************************************************************
 * Copyright 2013 AppGlu, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.michelzanini.logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Used to produce {@link Logger} instances.
 * 
 * <p>Using a String:<br>
 * <code>
 * Logger logger = LoggerFactory.getLogger("LOGGER_TAG");
 * </code>
 * 
 * <p>Using a Class:<br>
 * <code>
 * Logger logger = LoggerFactory.getLogger(this.getClass());
 * </code>
 * 
 * @see Logger
 * @see LoggerLevel
 * @since 1.0.0
 */
public class LoggerFactory {
	
	private static LoggerLevel level = LoggerLevel.INFO;
	
	private static final Map<String, AndroidLogger> loggerCache;
	
	static {
		loggerCache = new HashMap<String, AndroidLogger>();
	}
	
	public static LoggerLevel getLevel() {
		return level;
	}
	
	public static void setLevel(LoggerLevel loggerLevel) {
		if (loggerLevel != null) {
			level = loggerLevel;
		}
	}
	
	public static AndroidLogger getLogger(Class<?> clazz) {
		String tag = null;
		if (clazz != null) {
			tag = clazz.getSimpleName();
		}
		return getLogger(tag);
	}
	
	public static AndroidLogger getLogger(String tag) {
		AndroidLogger logger = null;
		
		synchronized (loggerCache) {
			logger = loggerCache.get(tag);
			if (logger == null) {
				logger = new AndroidLogger(tag);
				loggerCache.put(tag, logger);
			}
		}
		
		return logger;
	}

}

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
package com.github.michelzanini.logger;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;

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
	
	/**
	 * Sets the logger level based on a String
	 * @param loggerLevelString string is the name of the logger level (enum name in String)
	 */
	public static void setLevelFromString(String loggerLevelString) {
		LoggerLevel level = LoggerLevel.getLoggerLevel(loggerLevelString);
		
		if (level != LoggerLevel.NONE) {
			setLevel(level);
		}
	}
	
	/**
	 * Sets the logger level based on a String resource, taken from Android XML files
	 * @param context The Android Context object. Can be either an Application object or an Activity
	 * @param stringResourceId the R.string integer value to lookup the String on Android resources
	 */
	public static void setLevelFromStringResource(Context context, int stringResourceId) {
		String loggerLevelString = context.getString(stringResourceId);
		setLevelFromString(loggerLevelString);
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

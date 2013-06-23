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

/**
 * Provides all type of methods for logging to the console at any {@link LoggerLevel}.<br>
 * You can verify if a level is enabled for logging by calling the correspondent "isLevelEnabled" method. For example: {@link #isDebugEnabled()}.<br>
 * There are two options for logging a message and two options for logging an exception for each {@link LoggerLevel}.<br>
 * 
 * <p>You can have access to a {@code Logger} instance by using a {@link LoggerFactory#getLogger(String)} method, like below:
 * 
 * <p><code>
 * Logger logger = LoggerFactory.getLogger("LOGGER_TAG");
 * </code>
 * 
 * <p>To have access to a {@code Logger} instance, you can also send a Class as a parameter to {@link LoggerFactory#getLogger(Class)}.<br>
 * In this case the simple name of the class will be the log tag. For example:
 * 
 * <p><code>
 * Logger logger = LoggerFactory.getLogger(this.getClass());
 * </code>
 * 
 * @see LoggerLevel
 * @see LoggerFactory
 * @since 1.0.0
 */
public interface Logger {

	public String getTag();

	public boolean isVerboseEnabled();
	
	public boolean isDebugEnabled();
	
	public boolean isInfoEnabled();
	
	public boolean isWarnEnabled();
	
	public boolean isErrorEnabled();

	public void verbose(String msg);

	public void verbose(String format, Object... params);
	
	public void verbose(Throwable throwable);
	
	public void verbose(String msg, Throwable throwable);

	public void debug(String msg);
	
	public void debug(String format, Object... params);
	
	public void debug(Throwable throwable);

	public void debug(String msg, Throwable throwable);

	public void info(String msg);
	
	public void info(String format, Object... params);

	public void info(Throwable throwable);
	
	public void info(String msg, Throwable throwable);

	public void warn(String msg);
	
	public void warn(String format, Object... params);
	
	public void warn(Throwable throwable);

	public void warn(String msg, Throwable throwable);

	public void error(String msg);
	
	public void error(String format, Object... params);
	
	public void error(Throwable throwable);

	public void error(String msg, Throwable throwable);

}

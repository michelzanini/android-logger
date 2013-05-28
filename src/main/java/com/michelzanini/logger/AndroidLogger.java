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

import android.util.Log;

/**
 * Implements the {@link Logger} interface by using an Android Log class.
 * 
 * @see Logger
 * @see LoggerFactory
 * @see LoggerLevel
 * 
 * @since 1.0.0
 */
public class AndroidLogger implements Logger {
	
	static final int TAG_MAX_LENGTH = 23;
	
	private String tag;
	
	AndroidLogger(String tag) {
		if (tag == null) {
			throw new IllegalArgumentException("Tag cannot be null");
		}
		if (tag.length() > TAG_MAX_LENGTH) {
			tag = tag.substring(0, TAG_MAX_LENGTH);
		}
		this.tag = tag;
	}
	
	public String getTag() {
		return this.tag;
	}

	public boolean isVerboseEnabled() {
		return LoggerFactory.getLevel().getLevelAsInteger() <= Log.VERBOSE;
	}
	
	public boolean isDebugEnabled() {
		return LoggerFactory.getLevel().getLevelAsInteger() <= Log.DEBUG;
	}
	
	public boolean isInfoEnabled() {
		return LoggerFactory.getLevel().getLevelAsInteger() <= Log.INFO;
	}
	
	public boolean isWarnEnabled() {
		return LoggerFactory.getLevel().getLevelAsInteger() <= Log.WARN;
	}
	
	public boolean isErrorEnabled() {
		return LoggerFactory.getLevel().getLevelAsInteger() <= Log.ERROR;
	}

	public void verbose(String msg) {
		if (this.isVerboseEnabled()) {
			Log.v(tag, this.nullSafeMessage(msg));
		}
	}
	
	public void verbose(String format, Object... params) {
		if (this.isVerboseEnabled()) {
			String msg = formatMessage(format, params);
			Log.v(tag, this.nullSafeMessage(msg));
		}
	}

	public void verbose(Throwable throwable) {
		if (this.isVerboseEnabled()) {
			Log.v(tag, this.nullSafeMessage(throwable), throwable);
		}
	}

	public void verbose(String msg, Throwable throwable) {
		if (this.isVerboseEnabled()) {
			Log.v(tag, this.nullSafeMessage(msg), throwable);
		}
	}

	public void debug(String msg) {
		if (this.isDebugEnabled()) {
			Log.d(tag, this.nullSafeMessage(msg));
		}
	}
	
	public void debug(String format, Object... params) {
		if (this.isDebugEnabled()) {
			String msg = formatMessage(format, params);
			Log.d(tag, this.nullSafeMessage(msg));
		}
	}
	
	public void debug(Throwable throwable) {
		if (this.isDebugEnabled()) {
			Log.d(tag, this.nullSafeMessage(throwable), throwable);
		}
	}

	public void debug(String msg, Throwable throwable) {
		if (this.isDebugEnabled()) {
			Log.d(tag, this.nullSafeMessage(msg), throwable);
		}
	}
	
	public void info(String msg) {
		if (this.isInfoEnabled()) {
			Log.i(tag, this.nullSafeMessage(msg));
		}
	}
	
	public void info(String format, Object... params) {
		if (this.isInfoEnabled()) {
			String msg = formatMessage(format, params);
			Log.i(tag, this.nullSafeMessage(msg));
		}
	}

	public void info(Throwable throwable) {
		if (this.isInfoEnabled()) {
			Log.i(tag, this.nullSafeMessage(throwable), throwable);
		}
	}

	public void info(String msg, Throwable throwable) {
		if (this.isInfoEnabled()) {
			Log.i(tag, this.nullSafeMessage(msg), throwable);
		}
	}

	public void warn(String msg) {
		if (this.isWarnEnabled()) {
			Log.w(tag, this.nullSafeMessage(msg));
		}
	}
	
	public void warn(String format, Object... params) {
		if (this.isWarnEnabled()) {
			String msg = formatMessage(format, params);
			Log.w(tag, this.nullSafeMessage(msg));
		}
	}

	public void warn(Throwable throwable) {
		if (this.isWarnEnabled()) {
			Log.w(tag, this.nullSafeMessage(throwable), throwable);
		}
	}

	public void warn(String msg, Throwable throwable) {
		if (this.isWarnEnabled()) {
			Log.w(tag, this.nullSafeMessage(msg), throwable);
		}
	}

	public void error(String msg) {
		if (this.isErrorEnabled()) {
			Log.e(tag, this.nullSafeMessage(msg));
		}
	}
	
	public void error(String format, Object... params) {
		if (this.isErrorEnabled()) {
			String msg = formatMessage(format, params);
			Log.e(tag, this.nullSafeMessage(msg));
		}
	}

	public void error(Throwable throwable) {
		if (this.isErrorEnabled()) {
			Log.e(tag, this.nullSafeMessage(throwable), throwable);
		}
	}

	public void error(String msg, Throwable throwable) {
		if (this.isErrorEnabled()) {
			Log.e(tag, this.nullSafeMessage(msg), throwable);
		}
	}
	
	private String formatMessage(String format, Object... params) {
		try {
			return String.format(format, params);
		} catch (IllegalArgumentException e) {
			return this.nullSafeMessage(format);
		} catch (NullPointerException e) {
			return this.nullSafeMessage(format);
		}
	}
	
	private String nullSafeMessage(String msg) {
		if (msg == null) {
			return "null";
		}
		return msg;
	}
	
	private String nullSafeMessage(Throwable throwable) {
		if (throwable == null) {
			return "null";
		}
		return this.nullSafeMessage(throwable.getMessage());
	}

}

package com.tectoro.spring.hibernate.sample.domain;

	import java.io.Serializable;

import java.util.List;

	/**
	 * @author tectoro
	 *
	 */
	public class ResponseBean implements Serializable{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 8894393774984008181L;
		private Object data;
		private List<Object> objects;
		private String message;
		private String errorMessage;
		private boolean status;
		
		public ResponseBean(Object data, String message, String errorMessage, boolean status) {
			this.data = data;
			this.message = message;
			this.errorMessage = errorMessage;
			this.status = status;
		}

		public List<Object> getObjects() {
			return objects;
		}

		public void setObjects(List<Object> objects) {
			this.objects = objects;
		}

		public ResponseBean( List<Object> objects, String message, String errorMessage, boolean status) {
			this.objects = objects;
			this.message = message;
			this.errorMessage = errorMessage;
			this.status = status;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}
		
}

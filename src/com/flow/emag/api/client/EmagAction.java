package com.flow.emag.api.client;

public enum EmagAction {
	READ {
		public String toString(){
			return READ.toString().toLowerCase();
		}
	}
	, COUNT
	{
		public String toString(){
			return COUNT.toString().toLowerCase();
		}
	}
	, SAVE
	{
		public String toString(){
			return SAVE.toString().toLowerCase();
		}
	}
}

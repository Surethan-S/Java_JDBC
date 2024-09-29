package com.Surethan.ElectronicShop;

public class InvalidSeriesException extends Exception{
	public String getMessage() {
		return "Invalid Item, Item Not found";
	}
}

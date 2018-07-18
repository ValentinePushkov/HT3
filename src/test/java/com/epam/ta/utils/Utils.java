package com.epam.ta.utils;

import java.util.Random;

public class Utils
{
	private static final String AB09 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String ALL_NUMBERS = "0123456789";
	private static Random rnd = new Random();

	public static String getRandomString(int len)
	{
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
		{
			sb.append(AB09.charAt(rnd.nextInt(AB09.length())));
		}
		return sb.toString();
	}

	public static String getRandomLettersLine(int len)
	{
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
		{
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}
		return sb.toString();
	}

	public static String getRandomNumberLine(int len)
	{
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
		{
			sb.append(ALL_NUMBERS.charAt(rnd.nextInt(ALL_NUMBERS.length())));
		}
		return sb.toString();
	}

}

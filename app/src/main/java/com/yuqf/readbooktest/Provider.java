package com.yuqf.readbooktest;

import android.net.Uri;
import android.provider.BaseColumns;

public class Provider {

	public static final String Authority = "com.yuqf.readbooktest.provider.books";

	public static final class Book implements BaseColumns {
		public static final Uri BookUri = Uri.parse("content://" + Authority + "/book");
		// 表数据列
		public static final String BookName = "bookname";
	}
}

package jp.co.aforce.tool;

import java.io.PrintWriter;

public class Page {

	public static void header(PrintWriter out) {

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>和菓子通販:甘味堂</title>");
		out.println("</head>");
		out.println("<body>");

	}

	public static void footer(PrintWriter out) {

		out.println("</body>");
		out.println("</html>");
	}

}

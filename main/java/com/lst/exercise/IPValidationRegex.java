package com.lst.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * IP address is a string in the form "A.B.C.D", where the value of A, B, C, and
 * D may range from 0 to 255. Leading zeros are allowed. The length of A, B, C,
 * or D can't be greater than 3.
 * 
 * @author SiekThing Lim
 * 
 */
public class IPValidationRegex {

    public static boolean isValid(String ipAddr) {
        final String ipSegmentPattern = "(0?[0-9]?[0-9]|[0-1][0-9][0-9]|2[0-4][0-9]|25[0-5])";
        final StringBuilder ipPattern = new StringBuilder();
        ipPattern.append("^");
        ipPattern.append(ipSegmentPattern);
        ipPattern.append("\\.");
        ipPattern.append(ipSegmentPattern);
        ipPattern.append("\\.");
        ipPattern.append(ipSegmentPattern);
        ipPattern.append("\\.");
        ipPattern.append(ipSegmentPattern);
        ipPattern.append("$");

        final Pattern ptn = Pattern.compile(ipPattern.toString());
        final Matcher mtch = ptn.matcher(ipAddr);
        return mtch.find();
    }

    public InputStream getIpAddressFile() {
        final String fileName = "ipaddress.txt";
        InputStream in = getClass().getClassLoader().getResourceAsStream(
                fileName);
        if ( in == null ) {
            in = getClass().getClassLoader()
                    .getResourceAsStream("/" + fileName);
        }
        return in;
    }

    public void filterInvalidIpFromFile(final InputStream in) {
        final BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String sCurrentLine;
        try {
            while ( ( sCurrentLine = br.readLine() ) != null ) {
                if ( !isValid(sCurrentLine) )
                    System.out.println(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IPValidationRegex task = new IPValidationRegex();
        task.filterInvalidIpFromFile(task.getIpAddressFile());
    }

}

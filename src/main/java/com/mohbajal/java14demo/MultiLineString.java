package com.mohbajal.java14demo;

public class MultiLineString {

    //The Java compiler processes the content by removing incidental
    // white space to yield what the developer intended
    private static final String thisWillHaveALineBreakAtTheEnd =
            """
            <html>
                   <body>
                       <p>Hello, world</p>        
                   </body>
            </html>
            """;

    private static final String thisWillNotHaveALineBreakAtTheEnd =
            """
             <html>
                  <body>\
                      <p>Hello, world</p>
                  </body>\
             </html>""";

    public static void main(String[] args) {
      //  System.out.println("=="+ thisWillHaveALineBreakAtTheEnd.indent(20) + "==");
        System.out.println("=="+ thisWillNotHaveALineBreakAtTheEnd + "==");



    }

}

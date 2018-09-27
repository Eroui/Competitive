import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;

class Singleton{
    private static Singleton instance;
    public String str;
    
    private Singleton() {
        str = "Hello I am a singleton! Let me say hello world to you";
    }
    
    public static synchronized Singleton getSingleInstance() {
        if(instance == null) {
            return instance = new Singleton();
        }
        
        return instance;
    }
}
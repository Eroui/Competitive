import java.util.*;
import java.io.*;

class BiCycle{
	String define_me(){
		return "a vehicle with pedals.";
	}
}

class MotorCycle extends BiCycle{
	String define_me(){
		return "a cycle with an engine.";
	}
	
	MotorCycle(){
        System.out.println("Hello I am a motorcycle, I am "+ define_me());
        
        // Solution Start

        String temp= super.define_me(); //Fix this line

        // Solution End

        System.out.println("My ancestor is a cycle who is "+ temp );
	}
	
}
class Solution{
	public static void main(String []args){
		MotorCycle M=new MotorCycle();
	}
}

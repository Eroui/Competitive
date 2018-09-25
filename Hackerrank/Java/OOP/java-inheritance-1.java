// Solution Start
class Bird extends Animal
{
	void fly()
	{
		System.out.println("I am flying");
	}
    
    void sing() {
        System.out.println("I am singing");
    }
}
// Solution End 


public class Solution{

    public static void main(String args[]){
 
       Bird bird = new Bird();
       bird.walk();
       bird.fly();
       bird.sing();
     
    }
 }
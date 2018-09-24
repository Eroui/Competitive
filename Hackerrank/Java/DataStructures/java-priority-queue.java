import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Collections;

class Student implements Comparable<Student> {
    
    int id;
    String name;
    double cpga;

    public Student(int id, String name, double cpga) {
        this.id = id;
        this.name = name;
        this.cpga = cpga;
    }
    
    public int compareTo(Student s) {
        if(Math.abs(this.cpga - s.cpga) > 1e6)
            return Double.compare(s.cpga, this.cpga);
        if(!this.name.equals(s.name))
            return this.name.compareTo(s.name);
        
        return this.id - s.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getCpga() {
        return this.cpga;
    }
    
    public int getId() {
        return this.id;
    }
   
}

class Priorities {
    private PriorityQueue<Student> pq;
        
    public Priorities() {
        this.pq = new PriorityQueue<>(1,
                                      Comparator.comparing(Student::getCpga)
                                      .reversed()
                                      .thenComparing(Student::getName)
                                      .thenComparingInt(Student::getId)
                                     );
    }
        
    public List<Student> getStudents(List<String> events) {
        ArrayList<Student> students = new ArrayList<>();
        for(String event : events) {
            String[] tokens = event.split("\\s+");
            if(tokens[0].equals("ENTER")) {
                Student s = new Student(Integer.parseInt(tokens[3]),
                                           tokens[1], Double.parseDouble(tokens[2]));
                        
                pq.offer(s);
            } else {
                pq.poll();
            }
            
        }
        
        while(!pq.isEmpty()) {
            students.add(pq.poll());
        }
        
        return students;
    }
}
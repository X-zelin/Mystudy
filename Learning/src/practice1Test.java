import static org.junit.Assert.*;

public class practice1Test {

    @org.junit.Test
    public void removeDuplicates() {
        practice1 p = new practice1();
        int[] nums={0,0,1,2,};
        int k  = p.removeDuplicates(nums);
        System.out.println(k);
    }
}
package com.mnpsnuwan.datastructures.priorityqueue;

import static com.google.common.truth.Truth.assertThat;

import java.util.*;

import org.junit.jupiter.api.*;

/**
 * Created by IntelliJ IDEA.
 * Project : datastructures
 * Class : {@link BinaryHeapQuickRemovalsTest}
 * User : Nuwan Samarasinghe | mnpsnuwan@gmail.com
 * Date : 23Nov2023
 * Time : 10:06 PM
 */
public class BinaryHeapQuickRemovalsTest {

    static final int LOOPS = 100;
    static final int MAX_SZ = 100;

    @BeforeEach
    public void setup() {}

    @Test
    public void testEmpty() {
        BinaryHeapQuickRemovals<Integer> q = new BinaryHeapQuickRemovals<>();
        assertThat(q.size()).isEqualTo(0);
        assertThat(q.isEmpty()).isTrue();
        assertThat(q.poll()).isNull();
        assertThat(q.peek()).isNull();
    }

    @Test
    public void testHeapProperty() {

        BinaryHeapQuickRemovals<Integer> q = new BinaryHeapQuickRemovals<>();
        Integer[] nums = {3, 2, 5, 6, 7, 9, 4, 8, 1};

        // Try manually creating heap
        for (int n : nums) q.add(n);
        for (int i = 1; i <= 9; i++) assertThat(q.poll()).isEqualTo(i);

        q.clear();

        // Try heapify constructor
        q = new BinaryHeapQuickRemovals<>(nums);
        for (int i = 1; i <= 9; i++) assertThat(q.poll()).isEqualTo(i);
    }

    @Test
    public void testHeapify() {

        for (int i = 1; i < LOOPS; i++) {

            Integer[] lst = genRandArray(i);
            BinaryHeapQuickRemovals<Integer> pq = new BinaryHeapQuickRemovals<>(lst);

            PriorityQueue<Integer> pq2 = new PriorityQueue<>(i);
            pq2.addAll( Arrays.asList( lst ) );

            assertThat(pq.isMinHeap(0)).isTrue();

            while (!pq2.isEmpty()) {
                assertThat(pq.poll()).isEqualTo(pq2.poll());
            }
        }
    }

    @Test
    public void testClear() {

        BinaryHeapQuickRemovals<String> q;
        String[] strArray = {"aa", "bb", "cc", "dd", "ee"};
        q = new BinaryHeapQuickRemovals<>(strArray);
        q.clear();
        assertThat(q.size()).isEqualTo(0);
        assertThat(q.isEmpty()).isTrue();
    }

    @Test
    public void testContainment() {

        String[] strArray = {"aa", "bb", "cc", "dd", "ee"};
        BinaryHeapQuickRemovals<String> q = new BinaryHeapQuickRemovals<>(strArray);
        q.remove("aa");
        assertThat(q.contains("aa")).isFalse();
        q.remove("bb");
        assertThat(q.contains("bb")).isFalse();
        q.remove("cc");
        assertThat(q.contains("cc")).isFalse();
        q.remove("dd");
        assertThat(q.contains("dd")).isFalse();
        q.clear();
        assertThat(q.contains("ee")).isFalse();
    }

    @Test
    public void testContainmentRandomized() {

        for (int i = 0; i < LOOPS; i++) {

            List<Integer> randNums = genRandList(100);
            PriorityQueue<Integer> PQ = new PriorityQueue<>();
            BinaryHeapQuickRemovals<Integer> pq = new BinaryHeapQuickRemovals<>();
            for( Integer randNum : randNums )
            {
                pq.add( randNum );
                PQ.add( randNum );
            }

            for( int randVal : randNums )
            {

                assertThat( pq.contains( randVal ) ).isEqualTo( PQ.contains( randVal ) );
                pq.remove( randVal );
                PQ.remove( randVal );
                assertThat( pq.contains( randVal ) ).isEqualTo( PQ.contains( randVal ) );
            }
        }
    }

    public void sequentialRemoving(Integer[] in, Integer[] removeOrder) {

        assertThat(in.length).isEqualTo(removeOrder.length);

        BinaryHeapQuickRemovals<Integer> pq = new BinaryHeapQuickRemovals<>(in);
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for (int value : in) PQ.offer(value);

        assertThat(pq.isMinHeap(0)).isTrue();

        for( int elem : removeOrder )
        {

            assertThat( pq.peek() ).isEqualTo( PQ.peek() );
            assertThat( pq.remove( elem ) ).isEqualTo( PQ.remove( elem ) );
            assertThat( pq.size() ).isEqualTo( PQ.size() );
            assertThat( pq.isMinHeap( 0 ) ).isTrue();
        }

        assertThat(pq.isEmpty()).isTrue();
    }

    @Test
    public void testRemoving() {

        Integer[] in = {1, 2, 3, 4, 5, 6, 7};
        Integer[] removeOrder = {1, 3, 6, 4, 5, 7, 2};
        sequentialRemoving(in, removeOrder);

        in = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        removeOrder = new Integer[] {7, 4, 6, 10, 2, 5, 11, 3, 1, 8, 9};
        sequentialRemoving(in, removeOrder);

        in = new Integer[] {8, 1, 3, 3, 5, 3};
        removeOrder = new Integer[] {3, 3, 5, 8, 1, 3};
        sequentialRemoving(in, removeOrder);

        in = new Integer[] {7, 7, 3, 1, 1, 2};
        removeOrder = new Integer[] {2, 7, 1, 3, 7, 1};
        sequentialRemoving(in, removeOrder);

        in = new Integer[] {32, 66, 93, 42, 41, 91, 54, 64, 9, 35};
        removeOrder = new Integer[] {64, 93, 54, 41, 35, 9, 66, 42, 32, 91};
        sequentialRemoving(in, removeOrder);
    }

    @Test
    public void testRemovingDuplicates() {

        Integer[] in = new Integer[] {2, 7, 2, 11, 7, 13, 2};
        BinaryHeapQuickRemovals<Integer> pq = new BinaryHeapQuickRemovals<>(in);

        assertThat(pq.peek()).isEqualTo(2);
        pq.add(3);

        assertThat(pq.poll()).isEqualTo(2);
        assertThat(pq.poll()).isEqualTo(2);
        assertThat(pq.poll()).isEqualTo(2);
        assertThat(pq.poll()).isEqualTo(3);
        assertThat(pq.poll()).isEqualTo(7);
        assertThat(pq.poll()).isEqualTo(7);
        assertThat(pq.poll()).isEqualTo(11);
        assertThat(pq.poll()).isEqualTo(13);
    }

    @Test
    public void testRandomizedPolling() {

        for (int i = 0; i < LOOPS; i++) {

            List<Integer> randNums = genRandList( i );
            PriorityQueue<Integer> pq1 = new PriorityQueue<>();
            BinaryHeapQuickRemovals<Integer> pq2 = new BinaryHeapQuickRemovals<>();

            // Add all the elements to both priority queues
            for (Integer value : randNums) {
                pq1.offer(value);
                pq2.add(value);
            }

            while (!pq1.isEmpty()) {

                assertThat(pq2.isMinHeap(0)).isTrue();
                assertThat(pq1.size()).isEqualTo(pq2.size());
                assertThat(pq1.peek()).isEqualTo(pq2.peek());
                assertThat(pq1.contains(pq1.peek())).isEqualTo(pq2.contains(pq2.peek()));

                Integer v1 = pq1.poll();
                Integer v2 = pq2.poll();

                assertThat(v1).isEqualTo(v2);
                assertThat(pq1.peek()).isEqualTo(pq2.peek());
                assertThat(pq1.size()).isEqualTo(pq2.size());
                assertThat(pq2.isMinHeap(0)).isTrue();
            }
        }
    }

    @Test
    public void testRandomizedRemoving() {

        for (int i = 0; i < LOOPS; i++) {

            List<Integer> randNums = genRandList( i );
            PriorityQueue<Integer> pq1 = new PriorityQueue<>();
            BinaryHeapQuickRemovals<Integer> pq2 = new BinaryHeapQuickRemovals<>();

            // Add all the elements to both priority queues
            for (Integer value : randNums) {
                pq1.offer(value);
                pq2.add(value);
            }

            Collections.shuffle(randNums);
            int index = 0;

            while (!pq1.isEmpty()) {

                int removeNum = randNums.get(index++);

                assertThat(pq2.isMinHeap(0)).isTrue();
                assertThat(pq1.size()).isEqualTo(pq2.size());
                assertThat(pq1.peek()).isEqualTo(pq2.peek());
                pq1.remove(removeNum);
                pq2.remove(removeNum);
                assertThat(pq1.peek()).isEqualTo(pq2.peek());
                assertThat(pq1.size()).isEqualTo(pq2.size());
                assertThat(pq2.isMinHeap(0)).isTrue();
            }
        }
    }

    @Test
    public void testPQReUsability() {

        List<Integer> SZs = genUniqueRandList();

        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        BinaryHeapQuickRemovals<Integer> pq = new BinaryHeapQuickRemovals<>();

        for (int sz : SZs) {

            pq.clear();
            PQ.clear();

            List<Integer> nums = genRandList(sz);
            for (int n : nums) {
                pq.add(n);
                PQ.add(n);
            }

            Collections.shuffle(nums);

            for (int i = 0; i < sz / 2; i++) {

                // Sometimes add a new number into the BinaryHeapQuickRemovals
                if (0.25 < Math.random()) {
                    int randNum = (int) (Math.random() * 10000);
                    PQ.add(randNum);
                    pq.add(randNum);
                }

                int removeNum = nums.get(i);

                assertThat(pq.isMinHeap(0)).isTrue();
                assertThat(PQ.size()).isEqualTo(pq.size());
                assertThat(PQ.peek()).isEqualTo(pq.peek());

                PQ.remove(removeNum);
                pq.remove(removeNum);

                assertThat(PQ.peek()).isEqualTo(pq.peek());
                assertThat(PQ.size()).isEqualTo(pq.size());
                assertThat(pq.isMinHeap(0)).isTrue();
            }
        }
    }

    static Integer[] genRandArray(int sz) {
        Integer[] lst = new Integer[sz];
        for (int i = 0; i < sz; i++) lst[i] = (int) (Math.random() * MAX_SZ);
        return lst;
    }

    // Generate a list of random numbers
    static List<Integer> genRandList(int sz) {
        List<Integer> lst = new ArrayList<>(sz);
        for (int i = 0; i < sz; i++) lst.add((int) (Math.random() * MAX_SZ));
        return lst;
    }

    // Generate a list of unique random numbers
    static List<Integer> genUniqueRandList() {
        List<Integer> lst = new ArrayList<>( BinaryHeapQuickRemovalsTest.LOOPS );
        for ( int i = 0; i < BinaryHeapQuickRemovalsTest.LOOPS; i++) lst.add(i);
        Collections.shuffle(lst);
        return lst;
    }
}

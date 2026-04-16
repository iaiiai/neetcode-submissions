class MinHeap {
    List<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<Integer>();
        this.heap.add(0);
    }

    public void push(int val) {
        this.heap.add(val);
        int i = this.heap.size() - 1;
        while (i > 1 && this.heap.get(i) < this.heap.get(i / 2)) {
            int tmp = this.heap.get(i);
            this.heap.set(i, this.heap.get(i / 2));
            this.heap.set(i / 2, tmp);
            i = i / 2;
        }
    }
   

    public int pop() {
        if (this.heap.size() == 1 || this.heap.size() < 1) {
            return -1;
        }
        if (this.heap.size() == 2) {
            return this.heap.remove(this.heap.size() - 1);
        }
        int res = this.heap.get(1);
        this.heap.set(1, this.heap.remove(this.heap.size() - 1));
        int i = 1;
        while (2 * i < this.heap.size()) {
            if (2 * i + 1 < this.heap.size() && this.heap.get(2 * i + 1) < this.heap.get(2 * i) && this.heap.get(i) > this.heap.get(2 * i + 1)) {
                int tmp = this.heap.get(i);
                this.heap.set(i, this.heap.get(2 * i + 1));
                this.heap.set(2 * i + 1, tmp);
                i = 2 * i + 1;
            } else if (this.heap.get(i) > this.heap.get(2 * i)) {
                int tmp = this.heap.get(i);
                this.heap.set(i, this.heap.get(2 * i));
                this.heap.set(2 * i, tmp);
                i = 2 * i;
            } else {
                break;
            }
        }
        return res;
    }

    public Integer top() {
        if (this.heap.size() == 1) {
            return -1;
        }
        return this.heap.get(1);
    }

    public void heapify(List<Integer> nums) {
        if (nums.size() < 1) {
            return;
        }
        nums.add(nums.get(0));
        this.heap = nums;
        int cur = (this.heap.size() - 1) / 2;
        while (cur > 0) {
            int i = cur;
            while(2 * i < this.heap.size()) {
                if (2 * i + 1 < this.heap.size() && 
                this.heap.get(2 * i + 1) < this.heap.get(2 * i) 
                && this.heap.get(i) > this.heap.get(2 * i + 1)) {
                   int tmp = this.heap.get(i);
                   this.heap.set(i, this.heap.get(2 * i + 1));
                   this.heap.set(2 * i + 1, tmp);
                   i = 2 * i + 1;
                }
                else if (this.heap.get(i) > this.heap.get(2 * i)) {
                   int tmp = this.heap.get(i);
                   this.heap.set(i, this.heap.get(2 * i));
                   this.heap.set(2 * i, tmp);
                   i = 2 * i;
                 }
                else {
                   break;
                }
            }
            cur--;
        } 
        System.out.println("heapify " + this.heap);
    }
}
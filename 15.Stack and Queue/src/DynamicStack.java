public class DynamicStack extends CustomStack{

    public DynamicStack() {
        super();  // calls CustomStack() constructor
    }

    public DynamicStack(int size){
        super(size);  // calls CustomStack(size) constructor
    }

    @Override
    public boolean push(int item) {
        // when full
        if (this.isFull()){
            int[] temp = new int[2 * data.length];

            //copy
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

            data = temp;
        }

        // now push like CustomStack
        return super.push(item);
    }
}

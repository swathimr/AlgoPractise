package Stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedListIterator {


    public class NestedIterator implements Iterator<Integer> {

        Stack<NestedInteger> stack = new Stack<NestedInteger>();

        public NestedIterator(List<NestedInteger> nestedList) {
            if(nestedList==null)
                return;

            for(int i=nestedList.size()-1;i>=0;i--){
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while(!stack.isEmpty()) {
                NestedInteger top = stack.peek();
                if(top.isInteger())
                    return true;
                else {
                    stack.pop();
                    for(int i= top.getList().size()-1;i>=0;i--) {
                        stack.push(top.getList().get(i));
                    }
                }
            }
            return false;
        }
    }

    //given
    public interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }

}


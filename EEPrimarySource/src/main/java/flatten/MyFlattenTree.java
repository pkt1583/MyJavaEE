package flatten;

import java.util.ArrayList;
import java.util.List;

public class MyFlattenTree<T> implements FlattenTree<T> {

    public List<T> flattenInOrder(final Tree<T> tree) {
        final List<T> flattenedList=new ArrayList<>();
        Function<Triple<Tree<T>>,T> rightNavigable=new Function<Triple<Tree<T>>, T>() {
            @Override
            public T apply(Triple<Tree<T>> treeTriple) {
                List<Either<T,Triple<Tree<T>>>> tempList=new ArrayList<>();
                tempList.add(treeTriple.left().get());
                tempList.add(treeTriple.middle().get());
                tempList.add(treeTriple.right().get());
                for(Either<T,Triple<Tree<T>>> eitherVal:tempList){
                    if(eitherVal.isLeft()){
                        flattenedList.add(eitherVal.ifLeft(new Function<T, T>() {
                            @Override
                            public T apply(T t) {
                                return t;
                            }
                        }));
                    }else {
                        eitherVal.ifRight(this);
                    }
                }
                return null;
            }
        };
        if(tree==null){
            throw new IllegalArgumentException();
        }else{
            Either<T,Triple<Tree<T>>> node=tree.get();
            if(node.isLeft()){
                flattenedList.add(node.ifLeft(new Function<T, T>() {
                    @Override
                    public T apply(T t) {
                        return t;
                    }
                }));

            }else {
                node.ifRight(rightNavigable);
            }
            return flattenedList;
        }


    }

}

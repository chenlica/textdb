package Engine.Operators.Count;

import Engine.Common.AmberTag.LayerTag;
import Engine.Common.tuple.Tuple;
import Engine.Common.TupleProcessor;

import java.util.Collections;
import java.util.HashMap;

public class CountLocalTupleProcessor implements TupleProcessor {

    private boolean nextFlag = false;
    private int counter = 0;
    private HashMap<String,String> params = new HashMap<>();

    @Override
    public void accept(Tuple tuple){
        counter++;
    }

    @Override
    public void onUpstreamChanged(LayerTag from) {

    }

    @Override
    public void onUpstreamExhausted(LayerTag from) {

    }

    @Override
    public void noMore() {
        nextFlag = true;
    }

    public void updateParamMap() {
        params.put("counter", Integer.toString(counter));
    }

    @Override
    public void initialize() {updateParamMap();}

    @Override
    public String getParam(String query) throws Exception {
        return params.getOrDefault(query,null);
    }

    @Override
    public boolean hasNext() {
        return nextFlag;
    }

    @Override
    public Tuple next() {
        nextFlag = false;
        return Tuple.fromJavaList(Collections.singletonList(counter));
    }

    @Override
    public void dispose() {

    }
}
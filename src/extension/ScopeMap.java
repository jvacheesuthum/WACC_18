package extension;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vasin on 13/12/2015.
 */
public class ScopeMap<T,K> {
    private ScopeMap<T, K> encMap;
    private HashMap<T, K> thisMap;

    public ScopeMap(ScopeMap<T,K> encMap){
        this.thisMap = new HashMap<T,K>();
        this.encMap  = encMap;
    }

    public void put(T t, K v) {
        thisMap.put(t,v);
    }

    public K get(T t) {
        return thisMap.get(t);
    }

    public ScopeMap<T,K> getEnc(){
        return encMap;
    }

    public boolean hasEnc(){
        return encMap != null;
    }

    public K outwardsGet(T t){
        ScopeMap<T,K> currentSM = this;

        while(currentSM.get(t) == null && currentSM.hasEnc()){
            currentSM = currentSM.getEnc();
        }
        return currentSM.get(t);
    }
}

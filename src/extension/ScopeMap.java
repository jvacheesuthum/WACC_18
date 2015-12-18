package extension;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vasin on 13/12/2015.
 */
public class ScopeMap<T,K> {
    private ScopeMap<T, K> encMap;
    private HashMap<T, K> thisMap;
    private Set<String> arraysOrPairsDeclared = new HashSet<String>();

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
            if(arraysOrPairsDeclared.contains(t)) return null;
            currentSM = currentSM.getEnc();
        }
        return currentSM.get(t);
    }

    public void addArrayOrPairDeclared(String name) {
        arraysOrPairsDeclared.add(name);
    }
}

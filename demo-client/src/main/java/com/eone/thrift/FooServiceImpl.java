package com.eone.thrift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;

import com.eone.service.test.thrift.main.FooEnum;
import com.eone.service.test.thrift.main.FooService;
import com.eone.service.test.thrift.main.FooStruct;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/3-1:40 PM
 */
public class FooServiceImpl implements FooService.AsyncIface {
    @Override
    public void bar1(AsyncMethodCallback<Void> resultHandler) throws TException {
        resultHandler.onComplete(Void.TYPE.cast(null));
    }

    @Override
    public void bar2(AsyncMethodCallback<String> resultHandler) throws TException {
        resultHandler.onComplete("Hello");
    }

    @Override
    public void bar3(int intVal, FooStruct foo, AsyncMethodCallback<FooStruct> resultHandler) throws TException {
        FooStruct result = getFooStruct();
        resultHandler.onComplete(result);
    }

    private FooStruct getFooStruct() {
        FooStruct result = new FooStruct();
        result.setBoolVal(false)
              .setDoubleVal(123.11)
              .setEnumVal(FooEnum.VAL1);
        return result;
    }

    @Override
    public void bar4(List<FooStruct> foos, AsyncMethodCallback<List<FooStruct>> resultHandler) throws TException {
        List<FooStruct> list = new ArrayList<>();
        list.add(getFooStruct());
        list.add(getFooStruct());
        resultHandler.onComplete(list);
    }

    @Override
    public void bar5(Map<String, FooStruct> foos, AsyncMethodCallback<Map<String, FooStruct>> resultHandler) throws TException {
        Map<String, FooStruct> map = new HashMap<>();
        map.put("eone", getFooStruct());
        map.put("eonezhang", getFooStruct());
        resultHandler.onComplete(map);
    }

    @Override
    public void bar6(String foo1, FooStruct foo2, FooEnum foo3, Map<String, String> foo4, List<String> foo5, Set<String> foo6, List<List<FooStruct>> foo7,
                     List<List<FooStruct>> foo8, AsyncMethodCallback<Void> resultHandler) throws TException {
        resultHandler.onComplete(Void.TYPE.cast(null));
    }
}

package com.neo.mvel;

import org.mvel2.MVEL;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Chen Gong
 * @date：2021/4/22 5:39 下午
 */
public class T {
    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.setName("test");
        Map context = new HashMap();
        context.put("foo", foo);
        Serializable serializable = MVEL.compileExpression("foo.name");
        String eval = (String)MVEL.executeExpression(serializable, context);
        System.out.println(eval);

    }
}

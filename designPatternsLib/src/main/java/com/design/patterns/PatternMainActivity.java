package com.design.patterns;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 设计模式学习 1/9,<br>
 * 六大原则<br>
 * 1.单一职责<br>
 * 2.开闭原则：开放扩展，关闭修改<br>
 * 3.里氏替换原则：父类出现的位置，可以用子类替换<br>
 * 4.依赖倒置原则：依赖抽象，非具体实现<br>
 * 5.接口隔离原则：类之间的依赖关系应该建立在最小接口上<br>
 * 6.迪米特原则：只与直接朋友联系<br>
 */
public class PatternMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * 1.单例模式  singleton
     * 2.builder 模式
     * 3.原型模式  prototype
     * 4.工厂方法模式  factory method
     * 5.抽象工厂  abstract factory
     * 6.策略模式  Policy (Strategy Pattern)
     * 7.状态模式  state
     */
    private void studyPatterns() {
    }
}

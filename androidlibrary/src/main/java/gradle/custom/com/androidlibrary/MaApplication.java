package gradle.custom.com.androidlibrary;

import android.app.Application;
import android.content.res.Configuration;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public abstract class MaApplication extends Application {

    //mLogicList只持有当前进程的PriorityLogicWrapper对象
    private ArrayList<PriorityLogicWrapper> mLogicList;
    //mLogicClassMap持有所有进程的PriorityLogicWrapper数组对象
    private HashMap<String, ArrayList<PriorityLogicWrapper>> mLogicClassMap;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
        initializeLogic();
        dispatchLogic();
        instantiateLogic();

        if (null != mLogicList && mLogicList.size() > 0) {
            for (PriorityLogicWrapper priorityLogicWrapper : mLogicList) {
                if (null != priorityLogicWrapper && null != priorityLogicWrapper.instance) {
                    //找到当前进程的BaseApplicationLogic实例后，执行其onCreate()方法
                    priorityLogicWrapper.instance.onCreate();
                }
            }
        }
    }

    private void init() {
        mLogicClassMap = new HashMap<>();
    }

    public abstract boolean needMultipleProcess();

    //由MaApplication的实现类，去实现这个方法，调用registerApplicationLogic()
    //注册所有进程的BaseApplicationLogic对象
    protected abstract void initializeLogic();

    /**
     * 添加所有来自不同进程的，不同的BaseApplicationLogic对象到HashMap中
     * @param processName 进程名
     * @param priority 优先级
     * @param logicClass 继承BaseApplicationLogic的对象
     * @return
     */
    protected boolean registerApplicationLogic(String processName, int priority, @NonNull Class<? extends BaseApplicationLogic> logicClass) {
        boolean result = false;
        if (null != mLogicClassMap) {
            ArrayList<PriorityLogicWrapper> tempList = mLogicClassMap.get(processName);
            if (null == tempList) {
                tempList = new ArrayList<>();
                mLogicClassMap.put(processName, tempList);
            }
            if (tempList.size() > 0) {
                for (PriorityLogicWrapper priorityLogicWrapper : tempList) {
                    if (logicClass.getName().equals(priorityLogicWrapper.logicClass.getName())) {
                        throw new RuntimeException(logicClass.getName() + " has registered.");
                    }
                }
            }
            PriorityLogicWrapper priorityLogicWrapper = new PriorityLogicWrapper(priority, logicClass);
            tempList.add(priorityLogicWrapper);
            //tempList更新，则mLogicClassMap中的value也跟着更新了，不用再调用mLogicClassMap.put方法
        }
        return result;
    }

    /**
     * 得到一个属于本进程的ArrayList对象，里面保存着封装类PriorityLogicWrapper
     */
    private void dispatchLogic() {
        if (null != mLogicClassMap) {
            //根据进程名，得到该进程名对应的ArrayList<PriorityLogicWrapper>
//            mLogicList = mLogicClassMap.get(ProcessUtil.getProcessName(this, ProcessUtil.getMyProcessId()));
        }
    }

    /**
     * 取得mLogicList中的PriorityLogicWrapper对象，并按优先级顺序初始化BaseApplicationLogic对象
     */
    private void instantiateLogic() {
        if (null != mLogicList && mLogicList.size() > 0) {
            if (null != mLogicList && mLogicList.size() > 0) {
                Collections.sort(mLogicList); //根据进程优先级，按顺序初始化
                for (PriorityLogicWrapper priorityLogicWrapper : mLogicList) {
                    if (null != priorityLogicWrapper) {
                        try {
                            /**
                             * 调用Class.newInstance()，会创建这个Class的实例，但是不会执行Android中这个类相关的生命周期
                             * **/
                            priorityLogicWrapper.instance = priorityLogicWrapper.logicClass.newInstance();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        if (null != priorityLogicWrapper.instance) {
                            priorityLogicWrapper.instance.setApplication(this);
                        }
                    }
                }
            }
        }
    }

    //Application生命周期的处理，下面方法都类似
    @Override
    public void onTerminate() {
        super.onTerminate();
        if (null != mLogicList && mLogicList.size() > 0) {
            for (PriorityLogicWrapper priorityLogicWrapper : mLogicList) {
                if (null != priorityLogicWrapper && null != priorityLogicWrapper.instance) {
                    priorityLogicWrapper.instance.onTerminate();
                }
            }
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if (null != mLogicList && mLogicList.size() > 0) {
            for (PriorityLogicWrapper priorityLogicWrapper : mLogicList) {
                if (null != priorityLogicWrapper && null != priorityLogicWrapper.instance) {
                    priorityLogicWrapper.instance.onLowMemory();
                }
            }
        }
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (null != mLogicList && mLogicList.size() > 0) {
            for (PriorityLogicWrapper priorityLogicWrapper : mLogicList) {
                if (null != priorityLogicWrapper && null != priorityLogicWrapper.instance) {
                    priorityLogicWrapper.instance.onTrimMemory(level);
                }
            }
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (null != mLogicList && mLogicList.size() > 0) {
            for (PriorityLogicWrapper priorityLogicWrapper : mLogicList) {
                if (null != priorityLogicWrapper && null != priorityLogicWrapper.instance) {
                    priorityLogicWrapper.instance.onConfigurationChanged(newConfig);
                }
            }
        }
    }

}
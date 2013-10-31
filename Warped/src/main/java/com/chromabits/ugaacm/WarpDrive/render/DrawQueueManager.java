package com.chromabits.ugaacm.WarpDrive.render;

import java.util.ArrayList;

/**
 * Created by Eduardo Trujillo <ed@chromabits.com> on 10/30/13.
 */
public class DrawQueueManager {

    private ArrayList<DrawQueue> queues = new ArrayList<DrawQueue>();
    private int currentQueue;
    private GlRenderer renderer;

    public DrawQueueManager(GlRenderer renderer){
        // Add two queues
        queues.add(new DrawQueue());
        queues.add(new DrawQueue());

        // Set default queue
        currentQueue = 0;

        // Set renderer
        this.renderer = renderer;
    }

    public DrawQueue getWorkingQueue(){
        return queues.get(currentQueue);
    }

    private DrawQueue getRenderQueue(){
        if(currentQueue == 0){
            return queues.get(1);
        }else{
            return queues.get(0);
        }
    }

    public void swap(){
        if(currentQueue == 0){
            currentQueue = 1;
        }else{
            currentQueue = 0;
        }

        renderer.setDrawQueue(getRenderQueue());

        getWorkingQueue().clear();
    }
}

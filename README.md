HelloDrag
=========

Android program to drag the image in X Y co-ordinates of the screen.


**Android**  
drag/drop framework allows your users to move data from one View to another View in the current
layout using a graphical drag and drop gesture. The framework includes following three important components 
to support drag & drop functionality:
 Drag event class: 
 Drag listeners: 
 Helper methods and classes:

**The Drag/Drop Process**  
There are basically four steps or states in the drag and drop process:  

**Started:**  
This event occurs when you start dragging an item in a layout, your application callsstartDrag() 
method to tell the system to start a drag. The arguments inside startDrag() method provide the data to be dragged,
metadata for this data, and a callback for drawing the drag shadow. 
The system first responds by calling back to your application to get a drag shadow. 
It then displays the drag shadow on the device. Next, the system sends a drag event with action
type ACTION_DRAG_STARTED to the registered drag event listeners for all the View objects in the current layout. 
To continue to receive drag events, including a possible drop event, a drag event listener must return true, 
If the drag event listener returns false, then it will not receive drag events for the current operation until the 
system sends a drag event with action type ACTION_DRAG_ENDED.
  
 **Continuing:**    
The user continues the drag. System sends ACTION_DRAG_ENTERED action followed by ACTION_DRAG_LOCATION action 
to the registered drag event listener for the View where dragging point enters. 
The listener may choose to alter its View object's appearance in response to the event or can react by highlighting its View.
The drag event listener receives a ACTION_DRAG_EXITED action after the user has moved the drag shadow outside the 
bounding box of the View.

 **Dropped:**   
The user releases the dragged item within the bounding box of a View. 
The system sends the View object's listener a drag event with action type ACTION_DROP.

 **Ended:** 
Just after the action type ACTION_DROP, the system sends out a drag event with action type ACTION_DRAG_ENDED
to indicate that the drag operation is over.


**The DragEvent Class**  
The DragEvent represents an event that is sent out by the system at various times during a drag and drop operation. 
This class provides few Constants and important methods which we use during Drag/Drop process.

**CONSTANTS**  
1 ACTION_DRAG_STARTED : Signals the start of a drag and drop operation.  
2 ACTION_DRAG_ENTERED : Signals to a View that the drag point has entered the bounding box of the View.  
3 ACTION_DRAG_LOCATION : Sent to a View after ACTION_DRAG_ENTERED if the drag shadow is still within the View object's bounding box.  
4 ACTION_DRAG_EXITED   :  Signals that the user has moved the drag shadow outside the bounding box of the View.   
5 ACTION_DROP :  Signals to a View that the user has released the drag shadow, and the drag point is within the bounding box of the View.  
6 ACTION_DRAG_ENDED :  Signals to a View that the drag and drop operation has concluded.  

**METHODS**   
Following are few important and most frequently used methods available as a part of DragEvent class.  
1 int getAction() : Inspect the action value of this event..  
2 ClipData getClipData() : Returns the ClipData object sent to the system as part of the call to startDrag().  
3 ClipDescription getClipDescription() : Returns the ClipDescription object contained in the ClipData.  
4 boolean getResult() : Returns an indication of the result of the drag and drop operation.  
5 float getX()     :   Gets the X coordinate of the drag point.  
6 float getY()     :    Gets the Y coordinate of the drag point.  
7 String toString()   :   Returns a string representation of this DragEvent object.  

![Screen 1](https://github.com/ashokslsk/HelloDrag/blob/master/HelloDrag/Screens/Screen%201.png)  
![Screen 2](https://github.com/ashokslsk/HelloDrag/blob/master/HelloDrag/Screens/Screen%202.png)  
For more data and help ping me on 
ashokslsk@gmail.com


package ashu.fortuner.hellodrag;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class MainActivity extends Activity {
	
	// To hold image
	ImageView mImageView;
	private static final String IMAGEVIEW_TAG = "Android Blue logo";
	String msg;
	private android.widget.RelativeLayout.LayoutParams mLayoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.imageView1);
        mImageView.setTag(IMAGEVIEW_TAG);
        
        mImageView.setOnLongClickListener(new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				ClipData.Item item = new ClipData.Item((CharSequence)v.getTag());
				
				String[] mimeTypes = {
					ClipDescription.MIMETYPE_TEXT_PLAIN	
				};
				ClipData dragdata = new ClipData(v.getTag().toString(),mimeTypes,item);
				
				//Instantiate the drag shadow builder
				View.DragShadowBuilder myShadow = new DragShadowBuilder(mImageView);
				
				// To instantiate the drag shadow builder
				v.startDrag(dragdata, // the data to be dragged
						myShadow, // The dragsh
						null, // local data as of now not required  
						0);
				
				return true;
			}
		});
    
        // creating the drag event and setting the listner for the view
       mImageView.setOnDragListener(new OnDragListener() {
		
		@Override
		public boolean onDrag(View v, DragEvent event) {
			switch(event.getAction())
			{
			case DragEvent.ACTION_DRAG_STARTED:
				mLayoutParams = (RelativeLayout.LayoutParams)
				v.getLayoutParams();
				break;
			case DragEvent.ACTION_DRAG_ENTERED:
				int x_cord = (int) event.getX();
				int y_cord = (int) event.getY();
				break;
			case DragEvent.ACTION_DRAG_EXITED : 
				Log.d(msg, "Action is DragEvent.ACTION_DRAG_EXITED");
				x_cord = (int) event.getX(); 
				y_cord = (int) event.getY(); 
				mLayoutParams.leftMargin = x_cord; 
				mLayoutParams.topMargin = y_cord;
				v.setLayoutParams(mLayoutParams); 
				break;
			case DragEvent.ACTION_DRAG_LOCATION : 
				Log.d(msg, "Action is DragEvent.ACTION_DRAG_LOCATION"); 
				x_cord = (int) event.getX(); 
				y_cord = (int) event.getY();
				break; 
			case DragEvent.ACTION_DRAG_ENDED :
				Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENDED"); 
				// Do nothing 
				break; 
				case DragEvent.ACTION_DROP:
					Log.d(msg, "ACTION_DROP event"); 
					// Do nothing
					break;
				default: 
				break;
			}
			return true;
		}
	});
    }

}

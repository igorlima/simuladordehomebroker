package {
	import mx.controls.Label;
	import mx.controls.listClasses.*;
	
	public class DataGridPortifolioLabel extends Label {
		
		private const POSITIVE_COLOR:uint = 0x00FF00; // Green
		private const NEGATIVE_COLOR:uint = 0xFF0000; // Red
		
		override protected function updateDisplayList(unscaledWidth:Number, unscaledHeight:Number):void {
			super.updateDisplayList(unscaledWidth, unscaledHeight);
			
			/* Set the font color based on the item price. */
			setStyle("color", (parseFloat(data.variacao) <= 0) ? NEGATIVE_COLOR : POSITIVE_COLOR);
			
		}
	}
}
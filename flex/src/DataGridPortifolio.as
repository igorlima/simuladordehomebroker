package
{
	import flash.display.Sprite;
	
	import mx.collections.ArrayCollection;
	import mx.controls.DataGrid;
	
	public class DataGridPortifolio extends DataGrid{
		
		public var rowColorFunction:Function;
		
		override protected function drawRowBackground(s:Sprite, 
													  rowIndex:int, 
													  y:Number, 
													  height:Number, 
													  color:uint, 
													  dataIndex:int):void{
			
			/*if(rowColorFunction != null && dataProvider != null){
				var item:Object;
				
				if(dataIndex < dataProvider.length){
					item = dataProvider[dataIndex];
				}
				
				if(item){
					color = rowColorFunction(item, rowIndex, dataIndex, color);
				}
			}*/
			
			if( dataIndex % 2 != 1 ){
				color = 0x000000;
			}else{
				color = 0x222222;
			}
			
			super.drawRowBackground(s, rowIndex, y, height, color, dataIndex);
		}
	}
}
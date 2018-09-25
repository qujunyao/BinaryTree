package qujy;
/**
 * 二叉树
 * 
 * @author qujy
 *
 */
public class BTree {
	//元素内容
	private Object date;
	
	//层级
	private int floor;
	
	//左子结点
	private BTree left;
	
	//右子节点
	private BTree right;
	
	//x原坐标
	private int x;
	
	//x坐标
	private int x1;
	
	//y坐标
	private int y1;
	
	//x2坐标
	private int x2;
	
	//y2坐标
	private int y2;
	
	public int getFloor() {
		return floor;
	}
	
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	public Object getDate() {
		return date;
	}
	
	public void setDate(Object date) {
		this.date = date;
	}
	
	public BTree getLeft() {
		return left;
	}
	
	public void setLeft(BTree left) {
		this.left = left;
	}
	
	public BTree getRight() {
		return right;
	}
	
	public void setRight(BTree right) {
		this.right = right;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX1() {
		return x1;
	}
	
	public void setX1(int x1) {
		this.x1 = x1;
	}
	
	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	/**
	 * 默认构造方法
	 */
	public BTree() {}
	
	
	/**
	 * 构造方法:创建根节点
	 * @param date
	 * @param floor
	 * @param x
	 */
	public BTree(Object date,int floor,int x) {
		this.date = date;
		this.floor = floor;
		this.x = x;
		this.x1 = 2*x-1;
		this.x2 = this.x1+1;
		this.y1 = 0;
		this.y2 = 0;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * 构造方法:创建子节点
	 * @param date 内容
	 * @param floor 当前节点的层级
	 * @param root 父节点
	 * @param leftOrRight 左结点还是右节点 true:左 false:右
	 * @param level 整颗树的层级
	 */
	public BTree(Object date,int floor,BTree root,boolean leftOrRight,int level){
		this.date = date;
		this.floor = floor;
		this.left = null;
		this.right = null;
		this.x = comX(root.getX(),floor,leftOrRight);
		this.x1 = this.x * 2 - 1;
		this.x2 = this.x1+1;
		this.y1 = Power(level)-Power(floor);
		this.y2 = this.y1;
	}
	
	/**
	 * 根据根节点,计算子节点的坐标
	 * @param rootX 根节点的坐标
	 * @param rootFl 节点的层级
	 * @param leftOrRight 左结点还是右结点 true:左,false:右
	 * @return 子节点坐标
	 */
	public static int comX(int rootX,int rootFl,boolean leftOrRight) {
		int childerns = Power(rootFl)-2;
		int x = 0;
		if(leftOrRight) {//左结点
			x= rootX-((childerns+1)/2+1);
		}else{//右节点
			x= rootX+(childerns+1)/2+1;
		}
		return x;
	}
	
	/**
	 * 2的幂
	 * @param t
	 * @return
	 */
	private static int Power(int t) {  
		return (int) Math.ceil((Math.pow(2,t)));
	}
	
	public String toString2() {
		return "BTree [date=" + date + ", floor=" + floor +  ", x1=" + x1 + ", y1="	+ y1 + ", x2=" + x2 + ", y2=" + y2 +", left=" + left + ", right=" + right + "]";
	}
	
	public String toString() {
		return "BTree [date=" + date +", x="+x+ ", x1=" + x1 + ", y1="	+ y1 + ", x2=" + x2 + ", y2=" + y2+"]";
	}
	

}

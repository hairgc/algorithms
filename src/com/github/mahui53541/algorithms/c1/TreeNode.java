package com.github.mahui53541.algorithms.c1;

import java.util.ArrayList;
import java.util.Scanner;

/**   
 * @ClassName:  TreeNode   
 * @Description:定义一个多叉树（阿里测验题）
 * @author: mahui 
 * @date:   2017年7月9日 下午5:56:17   
 *     
 */ 
public class TreeNode {
	/**   
	 * @Fields parentId : 父节点Id
	 */  
	private int parentId;
	
	/**   
	 * @Fields nodeId : 节点Id
	 */  
	private int nodeId;
    /**   
     * @Fields cost : 耗时
     */  
    private int cost;
    
    /**   
     * @Fields parentNode : 父节点
     */  
    private TreeNode parentNode;
    
    /**   
     * @Fields childList : 子节点
     */  
    private ArrayList<TreeNode> childList;
 
    
    public TreeNode(int parentId, int nodeId, int cost) {
		this.parentId = parentId;
		this.nodeId = nodeId;
		this.cost = cost;
		initChildList();
    }
 
    public boolean isLeaf() {
        if (childList == null) {
            return true;
        } else {
            if (childList.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
    }
 
    /* 插入一个child节点到当前节点中 */
    public void addChildNode(TreeNode treeNode) {
        initChildList();
        childList.add(treeNode);
    }
 
    public void initChildList() {
        if (childList == null)
            childList = new ArrayList<TreeNode>();
    }
 
    public boolean isValidTree() {
        return true;
    }
 
    /* 返回当前节点的父辈节点集合 */
    public ArrayList<TreeNode> getElders() {
    	ArrayList<TreeNode> elderList = new ArrayList<TreeNode>();
        TreeNode parentNode = this.getParentNode();
        if (parentNode == null) {
            return elderList;
        } else {
            elderList.add(parentNode);
            elderList.addAll(parentNode.getElders());
            return elderList;
        }
    }
 
    /* 返回当前节点的晚辈集合 */
    public ArrayList<TreeNode> getJuniors() {
    	ArrayList<TreeNode> juniorList = new ArrayList<TreeNode>();
    	ArrayList<TreeNode> childList = this.getChildList();
        if (childList == null) {
            return juniorList;
        } else {
            int childNumber = childList.size();
            for (int i = 0; i < childNumber; i++) {
                TreeNode junior = childList.get(i);
                juniorList.add(junior);
                juniorList.addAll(junior.getJuniors());
            }
            return juniorList;
        }
    }
 
    /* 返回当前节点的孩子集合 */
    public ArrayList<TreeNode> getChildList() {
        return childList;
    }
 
    /* 删除节点和它下面的晚辈 */
    public void deleteNode() {
        TreeNode parentNode = this.getParentNode();
        int id = this.getNodeId();
 
        if (parentNode != null) {
            parentNode.deleteChildNode(id);
        }
    }
 
    /* 删除当前节点的某个子节点 */
    public void deleteChildNode(int childId) {
    	ArrayList<TreeNode> childList = this.getChildList();
        int childNumber = childList.size();
        for (int i = 0; i < childNumber; i++) {
            TreeNode child = childList.get(i);
            if (child.getNodeId() == childId) {
                childList.remove(i);
                return;
            }
        }
    }
 
    /* 动态的插入一个新的节点到当前树中 */
    public boolean insertJuniorNode(TreeNode treeNode) {
        int juniorParentId = treeNode.getParentId();
        if (this.nodeId == juniorParentId) {
        	treeNode.setParentNode(this);
            addChildNode(treeNode);
            return true;
        } else {
        	ArrayList<TreeNode> childList = this.getChildList();
            int childNumber = childList.size();
            boolean insertFlag;
 
            for (int i = 0; i < childNumber; i++) {
                TreeNode childNode = childList.get(i);
                insertFlag = childNode.insertJuniorNode(treeNode);
                if (insertFlag == true)
                    return true;
            }
            return false;
        }
    }
 
    /* 找到一颗树中某个节点 */
    public TreeNode findTreeNodeById(int id) {
        if (this.nodeId == id)
            return this;
        if (childList.isEmpty() || childList == null) {
            return null;
        } else {
            int childNumber = childList.size();
            for (int i = 0; i < childNumber; i++) {
                TreeNode child = childList.get(i);
                TreeNode resultNode = child.findTreeNodeById(id);
                if (resultNode != null) {
                    return resultNode;
                }
            }
            return null;
        }
    }
 
    /* 遍历一棵树，层次遍历，获取根节点到所有叶子节点的耗费 */
    public void traverse(int sumCost,ArrayList<Integer> costs) {
        if (nodeId < -1)
        	//costs.add(0);
            return;
        if (childList == null || childList.isEmpty()) {
        	costs.add(sumCost+cost);
            return;
        }
        for(TreeNode childNode:childList) {
        	childNode.traverse(sumCost+cost,costs);
        }
    }
    
    
    public static void main(String[] args) {
		ArrayList<Integer> _ids = new ArrayList<Integer>();
        ArrayList<Integer> _parents = new ArrayList<Integer>();
        ArrayList<Integer> _costs = new ArrayList<Integer>();

        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        while(line != null && !line.isEmpty()) {
            if(line.trim().equals("0")) break;
            String []values = line.trim().split(" ");
            if(values.length != 3) {
                break;
            }
            _ids.add(Integer.parseInt(values[0]));
            _parents.add(Integer.parseInt(values[1]));
            _costs.add(Integer.parseInt(values[2]));
            line = in.nextLine();
        }
        
        TreeNode root=new TreeNode(-1,0,0);
        int size=_ids.size();
        for(int i = 0;i <size ;i++){
        	root.insertJuniorNode(new TreeNode(_parents.get(i), _ids.get(i),_costs.get(i)));
        }
        
        ArrayList<Integer> costs=new ArrayList<Integer>();//所有花销
        root.traverse(0,costs);//遍历获取所有花销
        
        int maxCost=0;
        
        for(int cost:costs) {
        	maxCost=maxCost>cost?maxCost:cost;
        }
        
        System.out.println(maxCost);
	}
    public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
    public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}
	
    public void setChildList(ArrayList<TreeNode> childList) {
        this.childList = childList;
    }

	public TreeNode getParentNode() {
        return parentNode;
    }
 
    public void setParentNode(TreeNode parentNode) {
        this.parentNode = parentNode;
    }

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}  
}

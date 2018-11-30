package com.sigma.fileReader.tree;

//public void initialiseTree() throws IOException, JSONException {
//    this.setScrollPane(null);
//    this.setJtree(null);
//    this.setViewTree(null);
//    if(this.getPathMetaschema() == null) {
//        this.setNodeStorage(new NodeStorage(new ModelStorage("Empty root", "emptroot", null)));
//    }
//    else {
//        JSONinit(pathMetaschema);
//        setNodeStorage(new NodeStorage(this.getModelStorage()));
//    }   
//    this.setViewTree(new ViewTree(this.getNodeStorage()));
//    this.getViewTree().setMyRoot(this.getNodeStorage());
//    this.getViewTree().reload(this.getNodeStorage());
//    this.getViewTree().nodeChanged(this.getViewTree().getMyRoot());
////  this.getViewTree().addTreeSelectionListener(new ControllerTree(this));
////  TODO: OVO NIJE BILO OVDE VEC JE BILO U INICIJALIZACIJI POCETNOJ. RESITI PROBLEM.
//    setJtree(new JTree(this.getViewTree()));
//    jtree.setEditable(true);
//    DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) this.getViewTree().getRoot();
//    do {
//       if (currentNode.getLevel()==1) 
//            jtree.expandPath(new TreePath(currentNode.getPath()));
//       currentNode = currentNode.getNextNode();
//       }
//    while (currentNode != null);
////  jtree.setExpandsSelectedPaths(false);
//    jtree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
//    scrollPane = new JScrollPane(this.getJtree());
//    add(scrollPane, BorderLayout.WEST);
//    getJtree().setCellRenderer(new MyTreeCellRenderer());
//    SwingUtilities.updateComponentTreeUI(this.getJtree());
//
////  scrollPane.repaint();
////  this.getJtree().repaint();
////  this.repaint();
////  this.revalidate();
////  this.validate();
//}
//}
//
//import java.awt.Component;
//import javax.swing.tree.TreeNode;
//import javax.swing.tree.DefaultMutableTreeNode;
//import javax.swing.tree.DefaultTreeCellRenderer;
//import javax.swing.JTree;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//
//public final class TreeParser {
//	private TreeParser() {
//	}
//
//	protected static TreeParser parse(final Context context, final JsonObject el) throws Exception {
//		// create result
//		final DefaultTreeCellRenderer r = new DefaultTreeCellRenderer();
//
//		// TODO: add initJLabel
//
//
//		if (el.has("tree-cell-colors")) {
//			final JsonObject o = el.getAsJsonObject("tree-cell-colors");
//
//			if (o.has("bg"))
//				r.setBackground(Color.decode(o.get("bg").getAsString()));
//
//			if (o.has("non-selection")) {
//				final JsonObject h = o.getAsJsonObject("non-selection");
//
//				if (h.has("bg")) {
//					r.setBackgroundNonSelectionColor(context.getColor(h.get("bg").getAsString()));
//				}
//
//				if (h.has("text")) {
//					r.setTextNonSelectionColor(context.getColor(h.get("text").getAsString()));
//				}
//			}
//
//			if (o.has("selection")) {
//				final JsonObject h = o.getAsJsonObject("selection");
//
//				if (h.has("bg")) {
//					r.setBackgroundSelectionColor(context.getColor(h.get("bg").getAsString()));
//				}
//
//				if (h.has("text")) {
//					r.setTextSelectionColor(context.getColor(h.get("text").getAsString()));
//				}
//
//				if (h.has("border")) {
//					r.setBorderSelectionColor(context.getColor(h.get("border").getAsString()));
//				}
//			}
//		}
//
//		if (el.has("tree-cell-icons")) {
//			final JsonObject o = el.getAsJsonObject("tree-cell-icons");
//
//			if (o.has("closed"))
//				r.setClosedIcon(context.getIcon(o.get("closed").getAsString()));
//
//			if (o.has("leaf"))
//				r.setLeafIcon(context.getIcon(o.get("leaf").getAsString()));
//
//			if (o.has("open"))
//				r.setOpenIcon(context.getIcon(o.get("open").getAsString()));
//		}
//
//		// return result
//		return r;
//	}
//};
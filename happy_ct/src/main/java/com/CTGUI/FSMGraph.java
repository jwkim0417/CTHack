package com.CTGUI;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.model.mxGraphModel;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.layout.*;
import com.mxgraph.util.*;
import com.mxgraph.util.mxStyleUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import javax.swing.JPanel;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.ext.JGraphXAdapter;

public class FSMGraph extends JPanel {
    private JGraphXAdapter<FSMCell, FSMEdge> jgxAdapter;
    private DefaultDirectedGraph<FSMCell, FSMEdge> graph;
    private FSMCell current;
    private FSMCell start;
    private ArrayList<FSMCell> fsmCells;
    private ArrayList<FSMEdge> fsmEdges;

    private final String attr = "1 2 4\n1 3 5\n1 3 6\n0 5 4\n0 6 4\n0 2 5";

    public FSMGraph() {
        graph = new DefaultDirectedGraph<>(FSMEdge.class);
        fsmCells = new ArrayList<>();
        fsmEdges = new ArrayList<>();
        jgxAdapter = new JGraphXAdapter<>(graph);
        mxGraphComponent graphComponent = new mxGraphComponent(jgxAdapter);
        add(graphComponent);

        setGraph(attr);

        mxGraphLayout layout = new mxHierarchicalLayout(jgxAdapter);
        layout.execute(jgxAdapter.getDefaultParent());
    }

    public void setGraph(String attr) {
        removeAll();

        fsmCells.clear();
        fsmEdges.clear();

        String[] g = attr.split("\n");

        for(int i = 1; i < g.length + 1; i++){
            fsmCells.add(new FSMCell(i, g[i-1].split(" ")[0].equals("1")));
        }

        for(FSMCell c : fsmCells){
            graph.addVertex(c);
        }

        int j = 0;
        for(int i = 1; i < g.length + 1; i++){
            String[] tmp = g[i-1].split(" ");
            FSMEdge e1 = new FSMEdge(++j, true);
            FSMEdge e2 = new FSMEdge(++j, false);
            fsmEdges.add(e1);
            fsmEdges.add(e2);
            graph.addEdge(fsmCells.get(i - 1), fsmCells.get(Integer.parseInt(tmp[1]) - 1), e1);
            graph.addEdge(fsmCells.get(i - 1), fsmCells.get(Integer.parseInt(tmp[2]) - 1), e2);
        }

        jgxAdapter = new JGraphXAdapter<>(graph);
        mxGraphComponent graphComponent = new mxGraphComponent(jgxAdapter);
        mxGraphModel graphModel = (mxGraphModel)graphComponent.getGraph().getModel();
        Collection<Object> cells = graphModel.getCells().values();
        ArrayList<Object> cellsArray = new ArrayList<>(cells);

        ArrayList<Object> coop = new ArrayList<>();
        ArrayList<Object> bet = new ArrayList<>();
        ArrayList<Object> coopEdge = new ArrayList<>();
        ArrayList<Object> betEdge = new ArrayList<>();

        for(FSMCell c : fsmCells){
            if(c.coop) coop.add(cellsArray.get(cells.size() - c.id - 2));
            else bet.add(cellsArray.get(cells.size() - c.id - 2));
        }

        for(FSMEdge e : fsmEdges){
            if(e.coop) coopEdge.add(cellsArray.get(cells.size() - e.id - 2 - fsmCells.size()));
            else betEdge.add(cellsArray.get(cells.size() - e.id - 2 - fsmCells.size()));
        }

        //System.out.println(graphModel.getCells());
        //System.out.println(graphModel.getCells().keySet());
        //System.out.println(graphModel.getCells().get("5").toString());
        //System.out.println(Integer.parseInt(graphModel.getCells().get(Integer.toString(6)).toString().split("id=")[1].split(",")[0]));
        mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(),
                coop.toArray(), mxConstants.STYLE_FILLCOLOR, "#0000FF");
        mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(),
                coop.toArray(), mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
        mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(),
                bet.toArray(), mxConstants.STYLE_FILLCOLOR, "#FF0000");
        mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(),
                bet.toArray(), mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
        mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(),
                coopEdge.toArray(), mxConstants.STYLE_STROKECOLOR, "#0000FF");
        mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(),
                betEdge.toArray(), mxConstants.STYLE_STROKECOLOR, "#FF0000");

        graphComponent.setEnabled(false);
        add(graphComponent);
    }

    public void setCurrent(String id){
        Integer.parseInt(id);
    }

    private static class FSMCell {
        int id;
        boolean coop;
        FSMCell(int id, boolean coop) {
            this.id = id;
            this.coop = coop;
        }
        @Override
        public String toString() {
            return "";
        }
    }
    private static class FSMEdge extends DefaultEdge {
        int id;
        boolean coop;
        FSMEdge(int id, boolean coop) {
            this.id = id;
            this.coop = coop;
        }
        @Override
        public String toString() {
            return "";
        }
    }
}
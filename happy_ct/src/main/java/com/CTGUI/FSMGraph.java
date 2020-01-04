package com.CTGUI;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.model.mxGraphModel;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxUtils;
import java.util.Collection;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.ext.JGraphXAdapter;

public class FSMGraph extends JPanel {
    public FSMGraph()
    {
        JGraphXAdapter<String, DefaultEdge> jgxAdapter;
        DefaultDirectedGraph<String, DefaultEdge> graph =
                new DefaultDirectedGraph<>(DefaultEdge.class);

        graph.addVertex("v1");
        graph.addVertex("v2");
        graph.addVertex("v3");
        graph.addVertex("v4");
        graph.addVertex("v5");

        graph.addEdge("v1", "v2");
        graph.addEdge("v2","v3");
        graph.addEdge("v3", "v4");
        graph.addEdge("v4", "v1");
        graph.addEdge("v5", "v4");


        jgxAdapter = new JGraphXAdapter<>(graph);
        mxGraphComponent graphComponent = new mxGraphComponent(jgxAdapter);
        mxGraphModel graphModel  =       (mxGraphModel)graphComponent.getGraph().getModel();
        Collection<Object> cells =  graphModel.getCells().values();
        System.out.println(cells);
        mxUtils.setCellStyles(graphComponent.getGraph().getModel(),
                cells.toArray(), mxConstants.STYLE_ENDARROW, mxConstants.NONE);
        add(graphComponent);

        mxCircleLayout layout = new mxCircleLayout(jgxAdapter);
        layout.execute(jgxAdapter.getDefaultParent());

    }
    /*
    public static void main(String[] args) {

        FSMGraph g = new FSMGraph();
        
        g.setTitle(" undirected graph ");
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.pack();
        g.setVisible(true);
        
    }
    */
}
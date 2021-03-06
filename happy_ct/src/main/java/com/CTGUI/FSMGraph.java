package com.CTGUI;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.model.mxGraphModel;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.layout.*;
import com.mxgraph.util.*;
import com.mxgraph.util.mxStyleUtils;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JPanel;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.ext.JGraphXAdapter;

public class FSMGraph extends JPanel {
    private JGraphXAdapter<FSMCell, FSMEdge> jgxAdapter;
    private DefaultDirectedGraph<FSMCell, FSMEdge> graph;
    private int currentId;
    private ArrayList<FSMCell> fsmCells;
    private ArrayList<FSMEdge> fsmEdges;
    private mxGraphComponent graphComponent;
    private Collection<Object> cells;
    private ArrayList<Object> cellsArray;

    private final String attr2 = "C 1 5\r\nC 2 6\r\nC 3 7\r\nC 4 8\r\nC 5 9\r\nB 0 6\r\nB 1 7\r\nB 2 8\r\nB 3 9\r\nB 4 9";
    private final String attr = "C 1 3\r\nC 2 4\r\nC 2 5\r\nB 0 4\r\nB 1 5\r\nB 2 5";

    public FSMGraph() {
        graph = new DefaultDirectedGraph<>(FSMEdge.class);
        fsmCells = new ArrayList<>();
        fsmEdges = new ArrayList<>();
        jgxAdapter = new JGraphXAdapter<>(graph);
        mxGraphComponent graphComponent = new mxGraphComponent(jgxAdapter);
        add(graphComponent);

        setGraph(null);

        setBackground(Color.WHITE);
    }

    public void rePaint() {
        removeAll();

        jgxAdapter = new JGraphXAdapter<>(graph);
        graphComponent = new mxGraphComponent(jgxAdapter);
        mxGraphModel graphModel = (mxGraphModel) graphComponent.getGraph().getModel();
        cells = graphModel.getCells().values();
        cellsArray = new ArrayList<>(cells);

        cellsArray.sort((Comparator) (o1, o2) -> {
            int oid1 = Integer.parseInt(o1.toString().split("id=")[1].split(",")[0]);
            int oid2 = Integer.parseInt(o2.toString().split("id=")[1].split(",")[0]);
            if (oid1 > oid2) {
                return -1;
            } else if (oid1 < oid2) {
                return 1;
            }
            return 0;
        });

        ArrayList<Object> start = new ArrayList<>();
        start.add(cellsArray.get(cells.size() - 3));

        ArrayList<Object> coop = new ArrayList<>();
        ArrayList<Object> bet = new ArrayList<>();
        ArrayList<Object> coopEdge = new ArrayList<>();
        ArrayList<Object> betEdge = new ArrayList<>();
        ArrayList<Object> bothEdge = new ArrayList<>();

        for (FSMCell c : fsmCells) {
            if (c.coop)
                coop.add(cellsArray.get(cells.size() - c.id - 2));
            else
                bet.add(cellsArray.get(cells.size() - c.id - 2));
        }

        for (FSMEdge e : fsmEdges) {
            if (e.coop == 1)
                coopEdge.add(cellsArray.get(cells.size() - e.id - 2 - fsmCells.size()));
            else if (e.coop == 0)
                betEdge.add(cellsArray.get(cells.size() - e.id - 2 - fsmCells.size()));
            else
                bothEdge.add(cellsArray.get(cells.size() - e.id - 2 - fsmCells.size()));
        }

        // System.out.println(graphModel.getCells());
        // System.out.println(graphModel.getCells().keySet());
        // System.out.println(graphModel.getCells().get("5").toString());
        // System.out.println(Integer.parseInt(graphModel.getCells().get(Integer.toString(0)).toString().split("id=")[1].split(",")[0]));
        mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(), coop.toArray(), mxConstants.STYLE_FILLCOLOR,
                "#7ca1eb");
        mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(), coop.toArray(), mxConstants.STYLE_SHAPE,
                mxConstants.SHAPE_ELLIPSE);
        mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(), bet.toArray(), mxConstants.STYLE_FILLCOLOR,
                "#e872a7");
        mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(), bet.toArray(), mxConstants.STYLE_SHAPE,
                mxConstants.SHAPE_ELLIPSE);
        mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(), coopEdge.toArray(),
                mxConstants.STYLE_STROKECOLOR, "#0000FF");
        mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(), betEdge.toArray(),
                mxConstants.STYLE_STROKECOLOR, "#f53643");
        mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(), bothEdge.toArray(),
                mxConstants.STYLE_STROKECOLOR, "#000000");
        mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(), start.toArray(), mxConstants.STYLE_STROKEWIDTH,
                String.valueOf(3));
        mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(), start.toArray(), mxConstants.STYLE_STROKECOLOR,
                "#000000");

        graphComponent.setEnabled(false);
        graphComponent.getViewport().setBackground(Color.WHITE);
        add(graphComponent);
    }

    public void setGraph(String attr) {
        String content = null;
        if (attr == null) {
            return;
        }
        else {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(new File(attr)));
                System.out.println("HELLO");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FSMGraph.class.getName()).log(Level.SEVERE, null, ex);
            }
            content = reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
        System.out.println(content);
        
        graph = new DefaultDirectedGraph<>(FSMEdge.class);
        fsmCells.clear();
        fsmEdges.clear();

        String[] g = content.split("\r\n");

        for (int i = 1; i < g.length + 1; i++) {
            fsmCells.add(new FSMCell(i, g[i - 1].split(" ")[0].equals("C")));
        }

        for (FSMCell c : fsmCells) {
            graph.addVertex(c);
        }

        int j = 0;
        for (int i = 1; i < g.length + 1; i++) {
            String[] tmp = g[i - 1].split(" ");
            int source = fsmCells.get(i - 1).id;
            int target1 = fsmCells.get(Integer.parseInt(tmp[1])).id;
            int target2 = fsmCells.get(Integer.parseInt(tmp[2])).id;
            if(target1 == target2) {
                FSMEdge e = new FSMEdge(++j, 2, source, target1);
                fsmEdges.add(e);
                graph.addEdge(fsmCells.get(i - 1), fsmCells.get(Integer.parseInt(tmp[1])), e);
            }
            else {
                FSMEdge e1 = new FSMEdge(++j, 1, source, target1);
                FSMEdge e2 = new FSMEdge(++j, 0, source, target2);
                fsmEdges.add(e1);
                fsmEdges.add(e2);
                graph.addEdge(fsmCells.get(i - 1), fsmCells.get(Integer.parseInt(tmp[1])), e1);
                graph.addEdge(fsmCells.get(i - 1), fsmCells.get(Integer.parseInt(tmp[2])), e2);
            }
        }

        setCurrent(1, true);
    }

    public void setCurrent(int newId, boolean resetGraph) {
        rePaint();
        if(!resetGraph) {
            for (FSMEdge e : fsmEdges) {
                if (e.source == currentId && e.target == newId) {
                    ArrayList<Object> edge = new ArrayList<>();
                    edge.add(cellsArray.get(cells.size() - e.id - 2 - fsmCells.size()));

                    mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(), edge.toArray(),
                            mxConstants.STYLE_STROKEWIDTH, String.valueOf(3));
                    if (e.coop == 1) {
                        mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(), edge.toArray(),
                                mxConstants.STYLE_STROKECOLOR, "#40b7f7");
                    } else if (e.coop == 0) {
                        mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(), edge.toArray(),
                                mxConstants.STYLE_STROKECOLOR, "#eb4696");
                    } else {
                        mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(), edge.toArray(),
                                mxConstants.STYLE_STROKECOLOR, "#000000");
                    }
                    break;
                }
            }
        }
        else {
            System.out.println("RESET GRAPH?");
        }

        ArrayList<Object> current = new ArrayList<>();
        current.add(cellsArray.get(cells.size() - 2 - newId));

        mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(), current.toArray(),
                mxConstants.STYLE_STROKEWIDTH, String.valueOf(3));
        if (fsmCells.get(newId - 1).coop) {
            mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(), current.toArray(),
                    mxConstants.STYLE_STROKECOLOR, "#0000FF");
        } else {
            mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(), current.toArray(),
                    mxConstants.STYLE_STROKECOLOR, "#FF0000");
        }

        currentId = newId;

        mxGraphLayout layout = new mxHierarchicalLayout(jgxAdapter);
        layout.execute(jgxAdapter.getDefaultParent());
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
        int coop;
        int source;
        int target;

        FSMEdge(int id, int coop, int source, int target) {
            this.id = id;
            this.coop = coop;
            this.source = source;
            this.target = target;
        }

        @Override
        public String toString() {
            return "";
        }
    }
}
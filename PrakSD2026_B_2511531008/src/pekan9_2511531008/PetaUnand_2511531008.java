package pekan9_2511531008;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class PetaUnand_2511531008 extends JFrame {

	private Map<String, List<String>> graph_1008 = new HashMap<>();

    private JComboBox<String> start_1008;
    private JComboBox<String> goal_1008;

    private JTextArea hasil_1008;

    private GraphPanel_1008 panelGraph_1008;

    private Set<String> visitedNodes_1008 = new HashSet<>();

    public PetaUnand_2511531008() {

        setTitle("BFS & DFS Peta Universitas Andalas - 2511531008");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        buildGraph_1008();

        panelGraph_1008 = new GraphPanel_1008();

        JPanel control_1008 = new JPanel();

        start_1008 = new JComboBox<>();
        goal_1008 = new JComboBox<>();

        for(String node : graph_1008.keySet()){
            start_1008.addItem(node);
            goal_1008.addItem(node);
        }

        JButton bfs_1008 = new JButton("BFS");
        JButton dfs_1008 = new JButton("DFS");
        JButton reset_1008 = new JButton("Reset");

        control_1008.add(new JLabel("Start"));
        control_1008.add(start_1008);

        control_1008.add(new JLabel("Goal"));
        control_1008.add(goal_1008);

        control_1008.add(bfs_1008);
        control_1008.add(dfs_1008);
        control_1008.add(reset_1008);

        hasil_1008 = new JTextArea(10,30);
        hasil_1008.setEditable(false);

        add(control_1008, BorderLayout.NORTH);
        add(panelGraph_1008, BorderLayout.CENTER);
        add(new JScrollPane(hasil_1008), BorderLayout.SOUTH);

        bfs_1008.addActionListener(e -> BFS_1008());

        dfs_1008.addActionListener(e -> DFS_1008());

        reset_1008.addActionListener(e -> resetGraph_1008());
    }

    private void addEdge_1008(String a, String b){
        graph_1008.computeIfAbsent(a,k->new ArrayList<>()).add(b);
        graph_1008.computeIfAbsent(b,k->new ArrayList<>()).add(a);
    }

    private void buildGraph_1008(){

        addEdge_1008("Gerbang","Rektorat");
        addEdge_1008("Gerbang","Masjid");
        addEdge_1008("Gerbang","Perpustakaan");

        addEdge_1008("Rektorat","FT");
        addEdge_1008("Rektorat","FMIPA");

        addEdge_1008("FT","FMIPA");
        addEdge_1008("FT","FEB");

        addEdge_1008("FMIPA","FEB");
        addEdge_1008("FMIPA","FISIP");

        addEdge_1008("FEB","FISIP");
        addEdge_1008("FEB","FK");

        addEdge_1008("FK","RumahSakit");
        addEdge_1008("FK","Masjid");

        addEdge_1008("Masjid","Perpustakaan");
        addEdge_1008("Masjid","FISIP");

        addEdge_1008("Perpustakaan","Asrama");
        addEdge_1008("FISIP","Asrama");

        addEdge_1008("RumahSakit","Asrama");
    }

    public void BFS_1008(){

        String startNode_1008 =
                start_1008.getSelectedItem().toString();

        String goalNode_1008 =
                goal_1008.getSelectedItem().toString();

        Queue<String> queue_1008 = new LinkedList<>();

        Map<String,String> parent_1008 = new HashMap<>();

        Set<String> visited_1008 = new HashSet<>();

        List<String> urutan_1008 = new ArrayList<>();

        queue_1008.add(startNode_1008);
        visited_1008.add(startNode_1008);

        boolean found_1008 = false;

        while(!queue_1008.isEmpty()){

            String current_1008 = queue_1008.poll();

            urutan_1008.add(current_1008);

            if(current_1008.equals(goalNode_1008)){
                found_1008 = true;
                break;
            }

            for(String neighbor_1008 :
                    graph_1008.get(current_1008)){

                if(!visited_1008.contains(neighbor_1008)){

                    visited_1008.add(neighbor_1008);

                    parent_1008.put(neighbor_1008,
                            current_1008);

                    queue_1008.add(neighbor_1008);
                }
            }
        }

        visitedNodes_1008 = visited_1008;

        displayPath_1008(
                "BFS",
                startNode_1008,
                goalNode_1008,
                parent_1008,
                urutan_1008,
                visited_1008.size(),
                found_1008
        );
    }

    public void DFS_1008(){

        String startNode_1008 =
                start_1008.getSelectedItem().toString();

        String goalNode_1008 =
                goal_1008.getSelectedItem().toString();

        Stack<String> stack_1008 = new Stack<>();

        Map<String,String> parent_1008 = new HashMap<>();

        Set<String> visited_1008 = new HashSet<>();

        List<String> urutan_1008 = new ArrayList<>();

        stack_1008.push(startNode_1008);

        boolean found_1008 = false;

        while(!stack_1008.isEmpty()){

            String current_1008 = stack_1008.pop();

            if(!visited_1008.contains(current_1008)){

                visited_1008.add(current_1008);

                urutan_1008.add(current_1008);

                if(current_1008.equals(goalNode_1008)){
                    found_1008 = true;
                    break;
                }

                List<String> neighbors_1008 =
                        graph_1008.get(current_1008);

                Collections.reverse(neighbors_1008);

                for(String neighbor_1008 : neighbors_1008){

                    if(!visited_1008.contains(neighbor_1008)){

                        parent_1008.put(neighbor_1008,
                                current_1008);

                        stack_1008.push(neighbor_1008);
                    }
                }

                Collections.reverse(neighbors_1008);
            }
        }

        visitedNodes_1008 = visited_1008;

        displayPath_1008(
                "DFS",
                startNode_1008,
                goalNode_1008,
                parent_1008,
                urutan_1008,
                visited_1008.size(),
                found_1008
        );
    }

    public void displayPath_1008(
            String metode_1008,
            String startNode_1008,
            String goalNode_1008,
            Map<String,String> parent_1008,
            List<String> urutan_1008,
            int explored_1008,
            boolean found_1008){

        StringBuilder sb_1008 = new StringBuilder();

        sb_1008.append("Metode : ")
                .append(metode_1008)
                .append("\n");

        sb_1008.append("Urutan Kunjungan : ")
                .append(urutan_1008)
                .append("\n");

        sb_1008.append("Jumlah Node Dieksplorasi : ")
                .append(explored_1008)
                .append("\n");

        if(found_1008){

            List<String> path_1008 = new ArrayList<>();

            String current_1008 = goalNode_1008;

            while(current_1008 != null){

                path_1008.add(current_1008);

                current_1008 =
                        parent_1008.get(current_1008);
            }

            Collections.reverse(path_1008);

            sb_1008.append("Path : ")
                    .append(path_1008);
        }
        else{
            sb_1008.append("Path Tidak Ditemukan");
        }

        hasil_1008.setText(sb_1008.toString());

        panelGraph_1008.repaint();
    }

    public void resetGraph_1008(){

        visitedNodes_1008.clear();

        hasil_1008.setText("");

        panelGraph_1008.repaint();
    }

    class GraphPanel_1008 extends JPanel{

        Map<String,Point> posisi_1008 = new HashMap<>();

        public GraphPanel_1008(){

            posisi_1008.put("Gerbang",
                    new Point(100,100));

            posisi_1008.put("Rektorat",
                    new Point(250,80));

            posisi_1008.put("Masjid",
                    new Point(250,220));

            posisi_1008.put("Perpustakaan",
                    new Point(100,300));

            posisi_1008.put("FT",
                    new Point(450,80));

            posisi_1008.put("FMIPA",
                    new Point(450,180));

            posisi_1008.put("FEB",
                    new Point(600,120));

            posisi_1008.put("FISIP",
                    new Point(600,250));

            posisi_1008.put("FK",
                    new Point(750,150));

            posisi_1008.put("RumahSakit",
                    new Point(850,250));

            posisi_1008.put("Asrama",
                    new Point(500,350));
        }

        protected void paintComponent(Graphics g){

            super.paintComponent(g);

            for(String node_1008 : graph_1008.keySet()){

                Point p1_1008 =
                        posisi_1008.get(node_1008);

                for(String neighbor_1008 :
                        graph_1008.get(node_1008)){

                    Point p2_1008 =
                            posisi_1008.get(neighbor_1008);

                    g.drawLine(
                            p1_1008.x,
                            p1_1008.y,
                            p2_1008.x,
                            p2_1008.y
                    );
                }
            }

            for(String node_1008 : posisi_1008.keySet()){

                Point p_1008 =
                        posisi_1008.get(node_1008);

                if(visitedNodes_1008.contains(node_1008))
                    g.setColor(Color.GREEN);
                else
                    g.setColor(Color.LIGHT_GRAY);

                g.fillOval(
                        p_1008.x-20,
                        p_1008.y-20,
                        40,
                        40
                );

                g.setColor(Color.BLACK);

                g.drawOval(
                        p_1008.x-20,
                        p_1008.y-20,
                        40,
                        40
                );

                g.drawString(
                        node_1008,
                        p_1008.x-25,
                        p_1008.y-25
                );
            }
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new PetaUnand_2511531008().setVisible(true));
    }
}
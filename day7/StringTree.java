package day7;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StringTree<N extends Serializable> implements MutableTree<N>  {

    private final Map<N, N> nodeParent = new HashMap<>();
    private final LinkedHashSet<N> nodeList = new LinkedHashSet<>();

    @Override
    public List<N> getRoots() {
        return getChildren(null);
    }

    @Override
    public N getParent(N node) {
        checkNotNull(node, "node");
        return nodeParent.get(node);
    }


    @Override
    public List<N> getChildren(N node) {
        List<N> children = new LinkedList<>();
        for (N n : nodeList) {
            N parent = nodeParent.get(n);
            if (node == null && parent == null) {
                children.add(n);
            } else if (node != null && parent != null && parent.equals(node)) {
                children.add(n);
            }
        }
        return children;
    }

    @Override
    public boolean add(N parent, N node) {
        checkNotNull(parent, "parent");
        checkNotNull(node, "node");
        N current = parent;
        do {
            if (node.equals(current)) {
                throw new IllegalArgumentException(" node must not be the same or an ancestor of the parent");
            }
        } while ((current = getParent(current)) != null);

        boolean added = nodeList.add(node);
        nodeList.add(parent);
        nodeParent.put(node, parent);
        return added;
    }

    @Override
    public boolean remove(N node, boolean cascade) {
        checkNotNull(node, "node");
        if (!nodeList.contains(node)) {
            return false;
        }
        if (cascade) {
            for (N child : getChildren(node)) {
                remove(child, true);
            }
        } else {
            for (N child : getChildren(node)) {
                nodeParent.remove(child);
            }
        }
        nodeList.remove(node);
        return true;
    }
    private void checkNotNull(N node, String parameterName) {
        if (node == null)
            throw new IllegalArgumentException(parameterName + " must not be null");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        dumpNodeStructure(builder, null, "- ");
        return builder.toString();
    }

    private void dumpNodeStructure(StringBuilder builder, N node, String prefix) {
        if (node != null) {
            builder.append(prefix);
            builder.append(node.toString());
            builder.append('\n');
            prefix = "  " + prefix;
        }
        for (N child : getChildren(node)) {
            dumpNodeStructure(builder, child, prefix);
        }
    }

    
    
}

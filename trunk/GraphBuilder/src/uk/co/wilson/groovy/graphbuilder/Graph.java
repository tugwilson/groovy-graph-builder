/*
 * Created on 29 Jul 2007
 *
 * Copyright 2007 John G. Wilson
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
package uk.co.wilson.groovy.graphbuilder;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import groovy.lang.Closure;
import groovy.lang.GroovyObjectSupport;
import groovy.lang.Writable;

/**
 * @author John
 *
 */
public class Graph extends GroovyObjectSupport implements Writable {
  protected final String graphName;
  protected final Map<String, Node> nodes = new HashMap<String, Node>();


  /**
   * @param graphName
   * @param nodes
   */
  public Graph(final String graphName, final Closure closure) {
  final GraphBuilderDelegate delegate = new GraphBuilderDelegate() {
                                          /* (non-JavaDoc)
                                           * @see uk.co.wilson.groovy.graphbuilder.GraphBuilderDelegate#getNodes()
                                           */
                                          @Override
                                          protected Map<String, Node> getNodes() {
                                            return Graph.this.getNodes();
                                          }
                                        };

    closure.setDelegate(delegate);

    closure.call();

    this.graphName = graphName;
  }

  /**
   * @return
   */
  protected Map<String, Node> getNodes() {
    return this.nodes;
  }
  
  /* (non-JavaDoc)
   * @see groovy.lang.GroovyObjectSupport#getProperty(java.lang.String)
   */
  @Override
  public Object getProperty(final String property) {
    return this.nodes.get(property);
  }

  /* (non-JavaDoc)
   * @see groovy.lang.Writable#writeTo(java.io.Writer)
   */
  public Writer writeTo(final Writer out) throws IOException {
    out.write("digraph " + this.graphName + " {\n");
    out.write("rankdir=LR;\n");
    out.write("size=\"8,5\"\n");

    for (final Iterator<Node> iterator = this.nodes.values().iterator(); iterator.hasNext();) {
    final Node node = iterator.next();
    final String nodeName = node.getNodeName();
    final Node[] toNodes = node.getToNodes();
    final Node[] fromNodes = node.getFromNodes();

      for (int i = 0; i != toNodes.length; i++) {
        out.write(nodeName + " -> " + toNodes[i].getNodeName() + ";\n");
      }

      for (int i = 0; i != fromNodes.length; i++) {
        out.write(fromNodes[i].getNodeName() + " -> " + nodeName + ";\n");
      }
    }

    out.write("}\n");

    return out;
  }
}

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

import groovy.lang.GroovyInterceptable;
import groovy.lang.GroovyObjectSupport;

import java.util.Map;

public abstract class GraphBuilderDelegate extends GroovyObjectSupport implements GroovyInterceptable {
  /* (non-JavaDoc)
   * @see groovy.lang.GroovyObjectSupport#invokeMethod(java.lang.String, java.lang.Object)
   */
  @Override
  public Object invokeMethod(final String name, final Object args) {
  final Node node = new Node(name, args) {
                        /* (non-JavaDoc)
                         * @see uk.co.wilson.groovy.graphbuilder.Node#getFromNodes()
                         */
                        @Override
                        public Node[] getFromNodes() {
                          return findNodes(GraphBuilderDelegate.this.getNodes(), this.fromNodeNames);
                        }

                        /* (non-JavaDoc)
                         * @see uk.co.wilson.groovy.graphbuilder.Node#getToNodes()
                         */
                        @Override
                        public Node[] getToNodes() {
                          return findNodes(GraphBuilderDelegate.this.getNodes(), this.toNodeNames);
                        }
                     };

    this.getNodes().put(name, node);

    return node;
  }

  /* (non-JavaDoc)
   * @see groovy.lang.GroovyObjectSupport#getProperty(java.lang.String)
   */
  @Override
  public Object getProperty(final String property) {
    return property;
  }

  /* (non-JavaDoc)
   * @see groovy.lang.GroovyObjectSupport#setProperty(java.lang.String, java.lang.Object)
   */
  @Override
  public void setProperty(final String property, final Object newValue) {
    super.setProperty(property, newValue);
  }

  /**
   * @return the nodes
   */
  public abstract Map<String, Node> getNodes();
}

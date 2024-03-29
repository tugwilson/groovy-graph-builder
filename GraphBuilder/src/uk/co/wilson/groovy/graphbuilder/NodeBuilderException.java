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

import org.codehaus.groovy.ast.ASTNode;

import groovy.lang.GroovyRuntimeException;

/**
 * @author John
 *
 */
public class NodeBuilderException extends GroovyRuntimeException {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  /**
   * @param message
   * @param node
   */
  public NodeBuilderException(final String message, final ASTNode node) {
    super(message, node);
  }

  /**
   * @param message
   * @param cause
   */
  public NodeBuilderException(final String message, final Throwable cause) {
    super(message, cause);
  }

  /**
   * @param message
   */
  public NodeBuilderException(final String message) {
    super(message);
  }
}

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

import uk.co.wilson.groovy.graphbuilder.GraphBuilder

GraphBuilder.build("myGraph"){
  /*
   * A simple Graph builder
   * 
   * nodeName() declares a node called 'nodeName' with no incoming or outgoing edges and with no action
   * 
   * nodeName([nodeName2, nodeName3]) declares a node called 'nodeName' with outgoing edges to the nodes 'nodeName2' and 'nodeName3'
   *                                  but with no incoming edges and with no action
   * 
   * nodeName([nodeName2, nodeName3], [nodeName4, nodeName5]) declares a node called 'nodeName' with outgoing edges to the nodes 'nodeName2' and 'nodeName3'
   *                                                          and with incoming edges from the nodes 'nodeName2' and 'nodeName3'
   *                                                          but with no action
   * 
   * Following any of the above with a Closure specifies the Closure as the node's action
   * 
   * if only one incoming or outgoing edge to be specified than you can repace [nodeName] with nodeName
   * 
   */
  
  
  // You can execute arbitrary Groovy code here
  
  println "Executing the graph builder now"
  
	start(node1){
	  // you can put any Groovy statements in here
	  println "starting"
	}
	
	end {
	  
	}
	
	def links = [node1, node2]  // note that you don't have to use literal lists in the node specification
	             
	node1(start, links){
	}
	
	node2([node3, start]){
	}
	
	node3([], node4){
	}
	
	node4(end){
	}
}
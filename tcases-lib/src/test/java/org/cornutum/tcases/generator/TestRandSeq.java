//////////////////////////////////////////////////////////////////////////////
// 
//                    Copyright 2012, Cornutum Project
//                             www.cornutum.org
//
//////////////////////////////////////////////////////////////////////////////

package org.cornutum.tcases.generator;

import org.cornutum.tcases.util.Asserts;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Runs tests for {@link RandSeq}
 *
 */
public class TestRandSeq
  {
  @Test
  public void testReorderList()
    {
    // Given...
    RandSeq randSeq1 = new RandSeq( getClass().hashCode());
    Integer[] elements = new Integer[] {1, 2, 3, 5, 8, 13, 21};

    // When...
    List<Integer> sequence1 = randSeq1.reorder( new ArrayList<Integer>( Arrays.asList( elements)));

    // Then...
    Asserts.assertSetEquals( "New sequence", elements, sequence1);

    // Given...
    RandSeq randSeq2 = new RandSeq( new Random( getClass().hashCode()));

    // When...
    List<Integer> sequence2 = randSeq2.reorder( new ArrayList<Integer>( Arrays.asList( elements)));

    // Then...
    Asserts.assertSeqEquals( "Same seed", sequence1, sequence2); 
    }
  
  @Test
  public void testReorderIterator()
    {
    // Given...
    RandSeq randSeq = new RandSeq( RandSeq.class.hashCode());
    Integer[] elements = new Integer[] {1, 2, 3, 5, 8, 13, 21};

    // When...
    Iterator<Integer> sequence = randSeq.reorder( Arrays.asList( elements).iterator());

    // Then...
    Asserts.assertSetEquals( "New sequence", elements, sequence);
    }
  }




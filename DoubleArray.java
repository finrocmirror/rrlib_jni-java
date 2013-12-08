//
// You received this file as part of RRLib
// Robotics Research Library
//
// Copyright (C) Finroc GbR (finroc.org)
//
// This program is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License along
// with this program; if not, write to the Free Software Foundation, Inc.,
// 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
//
//----------------------------------------------------------------------
package org.rrlib.jni;

import java.nio.DoubleBuffer;


/**
 * @author Max Reichardt
 *
 * Array with doubles in C++ (double *)
 *
 * Lightweight implementation used for custom JNI implementations.
 *
 * In auto-generated JNI stuff, the DoubleArrayWrapper is the class to use.
 */
public class DoubleArray extends SharedBuffer {

    public DoubleBuffer dbuffer;

    public DoubleArray(double[] doubles) {
        super(doubles.length * 8);
        dbuffer = buffer.asDoubleBuffer();
        dbuffer.put(doubles);
    }

    /** Create array with specified size */
    public DoubleArray(int size) {
        super(size * 8);
        dbuffer = buffer.asDoubleBuffer();
    }

    /** Wrap existing C++ array */
    public DoubleArray(long pointer) {
        super(pointer);
        dbuffer = buffer.asDoubleBuffer();
    }

    /**
     * Only for buffers received from C++
     *
     * @param size Size information (in #doubles)
     */
    public void setSize(int size) {
        getCSideBuffer(size * 8);
        dbuffer = buffer.asDoubleBuffer();
    }
}

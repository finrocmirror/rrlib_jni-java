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

/**
 * @author Max Reichardt
 *
 * String with C++ (const char*) representation in memory
 */
public class CString extends SharedBuffer {

    /**
     * Creates String buffer for specified string
     */
    public CString(String s) {
        super(s.length() + 1);
        byte[] b = s.getBytes();
        for (int i = 0; i < b.length; i++) {
            super.buffer.put(i, b[i]);
        }
        super.buffer.put(b.length, (byte)0);
    }

    /**
     * Get String from specified pointer
     */
    public CString(long pointer) {
        super(pointer);
    }

    public String toString() {
        return JNICalls.toString(getPointer());
    }

    public int length() {
        return JNICalls.strlen(getPointer());
    }
}

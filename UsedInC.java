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

import java.util.ArrayList;
import java.util.List;

/**
 * @author Max Reichardt
 *
 * Marks all objects wrapping something that can also be used in C++
 */
public abstract class UsedInC {

    /** Objects and buffers that need to exist in C++ as long as this object does */
    protected List<Object> ownedObjects = new ArrayList<Object>();

    /** get Pointer of object on C side */
    public abstract long getPointer();

    public void addOwnedObject(Object uic) {
        ownedObjects.add(uic);
    }
}

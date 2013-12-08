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
 * Base class for "hybrid classes". These can be created and used
 * from both C++ and Java.
 *
 * Custom code on both sides is possible.
 *
 * (Preferably memory is allocated using Java byte buffer)
 */
public abstract class HybridClass extends SharedBuffer {

    /** Delete C++ class with garbage collection? */
    protected boolean delete;

    public HybridClass() {
        super(10);
        throw new RuntimeException("Invalid constructor... only there for code generation");
    }

    public HybridClass(int size) {
        super(size);
        delete = false;
    }

    public HybridClass(long pointer, boolean delete) {
        super(pointer);
        this.delete = delete;
    }

    @Override
    protected void finalize() throws Throwable {

        // Automatically delete C++ object with garbage collection
        super.finalize();
        if (delete && getPointer() != 0) {
            delete();
            setPointer(0);
        }
    }

    /** Delete Object */
    protected void delete() {}

    /** called when unknown object is registered and returns whether C++ object should be deleted with java garbage collection */
    protected abstract boolean register();
}

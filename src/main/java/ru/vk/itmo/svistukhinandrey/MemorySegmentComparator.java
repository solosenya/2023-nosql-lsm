package ru.vk.itmo.svistukhinandrey;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.Comparator;

public class MemorySegmentComparator implements Comparator<MemorySegment> {

    @Override
    public int compare(MemorySegment o1, MemorySegment o2) {
        long mismatch = o1.mismatch(o2);
        if (mismatch == -1) {
            return 0;
        }

        if (mismatch == o1.byteSize()) {
            return -1;
        }

        if (mismatch == o2.byteSize()) {
            return 1;
        }

        return o1.get(ValueLayout.JAVA_BYTE, mismatch) - o2.get(ValueLayout.JAVA_BYTE, mismatch);
    }
}

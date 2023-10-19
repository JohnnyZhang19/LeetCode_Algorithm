class Solution(object):
    def compress(self, chars):
        """
        :type chars: List[str]
        :rtype: int
        """
        if not chars:
            return 0
        write_index = 0
        read_index = 0
        count = 1
        while read_index < len(chars):
            if read_index == len(chars) - 1:
                chars[write_index] = chars[read_index]
                write_index += 1
                if count > 1:
                    for digit in str(count):
                        chars[write_index] = digit
                        write_index += 1
                break
            if chars[read_index] == chars[read_index + 1]:
                count += 1
            else:
                chars[write_index] = chars[read_index]
                write_index += 1
                if count > 1:
                    for digit in str(count):
                        chars[write_index] = digit
                        write_index += 1
                count = 1
            read_index += 1

        return write_index

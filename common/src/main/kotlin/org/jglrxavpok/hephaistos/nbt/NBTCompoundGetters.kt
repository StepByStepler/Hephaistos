package org.jglrxavpok.hephaistos.nbt

interface NBTCompoundGetters {

    /**
     * Returns the value associated to the given key, if any. Returns 'null' otherwise.
     */
    operator fun get(key: String): NBT?

    /**
     * Returns the value associated to the given key, if any. Returns 'defaultValue' otherwise.
     */
    fun getOrElse(key: String, defaultValue: NBT): NBT = get(key) ?: defaultValue

    /**
     * Returns the value associated to the given key, if any. Returns 'null' otherwise.
     * Also returns 'null' if the tag is not of the correct type (eg getByte on a NBTCompound will yield 'null')
     */
    fun getByte(key: String) = (get(key) as? NBTByte)?.value

    /**
     * Returns the value associated to the given key, if any. Returns 'null' otherwise.
     * Also returns 'null' if the tag is not of the correct type (eg getByte on a NBTCompound will yield 'null')
     *
     * Uses `NBTByte#asBoolean()` to determine the truthness
     */
    fun getBoolean(key: String) = (get(key) as? NBTByte)?.asBoolean()

    /**
     * Returns the value associated to the given key, if any. Returns 'null' otherwise.
     * Also returns 'null' if the tag is not of the correct type (eg getByte on a NBTCompound will yield 'null')
     */
    fun getByteArray(key: String) = (get(key) as? NBTByteArray)?.value

    /**
     * Returns the value associated to the given key, if any. Returns 'null' otherwise.
     * Also returns 'null' if the tag is not of the correct type (eg getByte on a NBTCompound will yield 'null')
     */
    fun getCompound(key: String) = (get(key) as? NBTCompound)

    /**
     * Returns the value associated to the given key, if any. Returns 'null' otherwise.
     * Also returns 'null' if the tag is not of the correct type (eg getByte on a NBTCompound will yield 'null')
     */
    fun getDouble(key: String) = (get(key) as? NBTDouble)?.value

    /**
     * Returns the value associated to the given key, if any. Returns 'null' otherwise.
     * Also returns 'null' if the tag is not of the correct type (eg getByte on a NBTCompound will yield 'null')
     */
    fun getFloat(key: String) = (get(key) as? NBTFloat)?.value

    /**
     * Returns the value associated to the given key, if any. Returns 'null' otherwise.
     * Also returns 'null' if the tag is not of the correct type (eg getByte on a NBTCompound will yield 'null')
     */
    fun getInt(key: String) = (get(key) as? NBTInt)?.value

    /**
     * Returns the value associated to the given key, if any. Returns 'null' otherwise.
     * Also returns 'null' if the tag is not of the correct type (eg getByte on a NBTCompound will yield 'null')
     */
    fun getIntArray(key: String) = (get(key) as? NBTIntArray)?.value

    /**
     * Returns the value associated to the given key, if any. Returns 'null' otherwise.
     * Also returns 'null' if the tag is not of the correct type (eg getByte on a NBTCompound will yield 'null')
     */
    fun getLong(key: String) = (get(key) as? NBTLong)?.value

    /**
     * Returns the value associated to the given key, if any. Returns 'null' otherwise.
     * Also returns 'null' if the tag is not of the correct type (eg getByte on a NBTCompound will yield 'null')
     */
    fun getLongArray(key: String) = (get(key) as? NBTLongArray)?.value

    /**
     * Returns the value associated to the given key, if any. Returns 'null' otherwise.
     * Also returns 'null' if the tag is not of the correct type (eg getByte on a NBTCompound will yield 'null')
     */
    fun getShort(key: String) = (get(key) as? NBTShort)?.value

    /**
     * Returns the value associated to the given key, if any. Returns 'null' otherwise.
     * Also returns 'null' if the tag is not of the correct type (eg getByte on a NBTCompound will yield 'null')
     */
    fun getNumber(key: String) = (get(key) as? NBTNumber<out Number>)?.value

    /**
     * Calls getNumber and cast to the desired type.
     * This is different from the get#Type# methods as this will attempt to cast the value instead of returning 'null'
     * if the tag is not the exact type (eg getByte returns null for a float, but getAsByte will cast)
     */
    fun getAsByte(key: String) = getNumber(key)?.toByte()

    /**
     * Calls getNumber and cast to the desired type.
     * This is different from the get#Type# methods as this will attempt to cast the value instead of returning 'null'
     * if the tag is not the exact type (eg getByte returns null for a float, but getAsByte will cast)
     */
    fun getAsDouble(key: String) = getNumber(key)?.toDouble()

    /**
     * Calls getNumber and cast to the desired type.
     * This is different from the get#Type# methods as this will attempt to cast the value instead of returning 'null'
     * if the tag is not the exact type (eg getByte returns null for a float, but getAsByte will cast)
     */
    fun getAsFloat(key: String) = getNumber(key)?.toFloat()

    /**
     * Calls getNumber and cast to the desired type.
     * This is different from the get#Type# methods as this will attempt to cast the value instead of returning 'null'
     * if the tag is not the exact type (eg getByte returns null for a float, but getAsByte will cast)
     */
    fun getAsInt(key: String) = getNumber(key)?.toInt()

    /**
     * Calls getNumber and cast to the desired type.
     * This is different from the get#Type# methods as this will attempt to cast the value instead of returning 'null'
     * if the tag is not the exact type (eg getByte returns null for a float, but getAsByte will cast)
     */
    fun getAsLong(key: String) = getNumber(key)?.toLong()

    /**
     * Calls getNumber and cast to the desired type.
     * This is different from the get#Type# methods as this will attempt to cast the value instead of returning 'null'
     * if the tag is not the exact type (eg getByte returns null for a float, but getAsByte will cast)
     */
    fun getAsShort(key: String) = getNumber(key)?.toShort()

    /**
     * Returns the value associated to the given key, if any. Returns 'null' otherwise.
     * Also returns 'null' if the tag is not of the correct type (eg getByte on a NBTCompound will yield 'null')
     */
    fun getString(key: String) = (get(key) as? NBTString)?.value

    /**
     * Returns the value associated to the given key, if any. Returns 'null' otherwise.
     * Also returns 'null' if the tag is not of the correct type (eg getByte on a NBTCompound will yield 'null')
     */
    fun <T: NBT> getList(key: String): NBTList<T>? = get(key) as? NBTList<T>

}
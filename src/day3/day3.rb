

def find_joltage(line)
  joltage = 0
  line.each_char.with_index do |c, i|
    # puts "#{i}: #{c}"
    line[i+1..-1].each_char.with_index do |c2, i2|
      new_joltage = "#{c}#{c2}".to_i
      joltage = new_joltage if (new_joltage > joltage)
    end
  end
  return joltage
end

total = 0
File.open("input.txt").each do |line|
  line.chop!
  puts "--+ Starting: #{line}"
  joltage = find_joltage(line)
  total += joltage
  puts "  + Best joltage: #{joltage}"
end
puts "--+ Total: #{total}"
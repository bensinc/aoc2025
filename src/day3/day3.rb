
def build_array(line)
  back = []
  line.chop.each_char.with_index do |c,i|
    back << [i, c]
  end
  #puts back.to_s
  return back.sort { |a, b| a[1] <=> b[1]}.reverse
end

File.open("input2.txt").each do |line|
  line.chop!
  puts "--+ Starting: #{line}"
  
  joltage = 0
  line.each_char.with_index do |c, i|
    joltage = c
    puts c
  end
  puts "  + #{joltage}"
end